package app.vazovsky.kinopoiskdev.presentation.movie

import android.os.Bundle
import androidx.core.graphics.Insets
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.data.model.Genre
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.model.MovieLengthDataType
import app.vazovsky.kinopoiskdev.data.model.SimilarMovie
import app.vazovsky.kinopoiskdev.databinding.FragmentMovieBinding
import app.vazovsky.kinopoiskdev.extensions.addDefaultGridSpaceItemDecoration
import app.vazovsky.kinopoiskdev.extensions.addLinearSpaceItemDecoration
import app.vazovsky.kinopoiskdev.extensions.doOnApplyWindowInsets
import app.vazovsky.kinopoiskdev.extensions.fitTopInsetsWithPadding
import app.vazovsky.kinopoiskdev.extensions.load
import app.vazovsky.kinopoiskdev.extensions.updateMargins
import app.vazovsky.kinopoiskdev.managers.DataTypeFormatter
import app.vazovsky.kinopoiskdev.presentation.base.BaseFragment
import app.vazovsky.kinopoiskdev.presentation.movie.genres.GenresAdapter
import app.vazovsky.kinopoiskdev.presentation.movie.similar.SimilarMoviesAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieFragment : BaseFragment(R.layout.fragment_movie) {

    private val binding by viewBinding(FragmentMovieBinding::bind)
    private val viewModel: MovieViewModel by viewModels()

    private val args by navArgs<MovieFragmentArgs>()
    private val id by lazy { args.id }

    @Inject lateinit var dataTypeFormatter: DataTypeFormatter
    @Inject lateinit var genresAdapter: GenresAdapter
    @Inject lateinit var similarMoviesAdapter: SimilarMoviesAdapter

    override fun callOperations() {
        viewModel.getMovie(id)
    }

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()
        toolbar.setNavigationOnClickListener { viewModel.navigateBack() }
        setupInsets()

        stateViewFlipper.setRetryMethod { viewModel.getMovie(id) }

        setupGenres()
        setupSimilarMovies()
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
        movieLiveData.observe { result ->
            binding.stateViewFlipper.setStateFromResult(result)
            setupVisibility(result.isSuccess)
            result.doOnSuccess { movie ->
                bindMovie(movie)
            }
        }
    }

    /** Настройка системных отступов */
    private fun setupInsets() = with(binding) {
        root.doOnApplyWindowInsets { _, insets, _ ->
            val windowInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            toolbar.updateMargins(top = windowInsets.top)
            WindowInsetsCompat.Builder().setInsets(
                WindowInsetsCompat.Type.systemBars(), Insets.of(
                    windowInsets.left, 0, windowInsets.right, windowInsets.bottom
                )
            ).build()
        }
    }

    /** Настройка списка жанров */
    private fun setupGenres() = with(binding) {
        recyclerViewGenres.adapter = genresAdapter.apply {
            onItemClick = {}
        }
        recyclerViewGenres.addDefaultGridSpaceItemDecoration(
            spanCount = 4,
            spacing = R.dimen.padding_4,
            includeEdge = true,
        )
    }

    private fun setupSimilarMovies() = with(binding.content) {
        recyclerViewSimilarMovies.adapter = similarMoviesAdapter.apply {
            onItemClick = {}
        }
        recyclerViewSimilarMovies.addLinearSpaceItemDecoration(
            spacing = R.dimen.padding_16,
            showFirstVerticalDivider = true,
            showLastVerticalDivider = true,
        )
    }

    /** Настройка отображения кнопки просмотра и постера */
    private fun setupVisibility(isVisible: Boolean) = with(binding) {
        constraintLayoutParallax.isVisible = isVisible
        buttonShow.isVisible = isVisible
    }

    /** Привязка информации о фильме */
    private fun bindMovie(movie: Movie) = with(binding) {
        toolbar.title = buildString {
            append(movie.name)
            if (movie.name.isNotBlank() && movie.year != 0) {
                append(", ")
            }
            append(movie.year)
        }
        imageViewBackground.load(
            imageUrl = movie.poster.url,
            placeHolderRes = R.drawable.img_preview,
            errorRes = R.drawable.img_preview,
        )

        bindGenres(movie.genres)
        bindDescription(movie.description)
        bindMovieLength(movie.movieLength)
        /** TODO сделать рейтинг */
        similarMoviesAdapter.submitList(movie.similarMovies)

        buttonShow.setOnClickListener {
            /** TODO переход к просмотру фильма */
        }
    }

    private fun bindMovieLength(movieLength: MovieLengthDataType) = with(binding.content) {
        val isMovieLengthFilled = movieLength != 0
        textViewMovieLength.isVisible = isMovieLengthFilled
        textViewMovieLength.text = if (isMovieLengthFilled) {
            buildString {
                append(getString(R.string.movie_movie_length_prefix))
                append(" ")
                append(dataTypeFormatter.formatMovieLength(movieLength))
            }
        } else ""
    }

    /** Привязка жанров */
    private fun bindGenres(genres: List<Genre>) {
        genresAdapter.submitList(genres)
    }

    /** Привязка описания */
    private fun bindDescription(description: String) = with(binding.content) {
        textViewDescription.text = description

        val hasDescription = description.isNotBlank()

        textViewDescriptionLabel.isVisible = hasDescription
        textViewDescription.isVisible = hasDescription
        textViewDescriptionExpand.isVisible = false

        if (hasDescription) {
            textViewDescription.maxLines = Int.MAX_VALUE
            textViewDescription.text = description
            textViewDescription.doOnPreDraw {
                val isExpanded = viewModel.isDescriptionExpanded
                textViewDescriptionExpand.text = getDescriptionExpandText(isExpanded)

                if (isExpanded) {
                    textViewDescription.maxLines = Int.MAX_VALUE
                } else {
                    val needToShowExpandedButton = textViewDescription.lineCount > 3
                    textViewDescriptionExpand.isVisible = needToShowExpandedButton
                    textViewDescription.maxLines = getDescriptionLineCount(!needToShowExpandedButton)
                }
            }
            textViewDescriptionExpand.setOnClickListener {
                viewModel.isDescriptionExpanded = !viewModel.isDescriptionExpanded
                textViewDescriptionExpand.text = getDescriptionExpandText(viewModel.isDescriptionExpanded)
                textViewDescription.maxLines = getDescriptionLineCount(viewModel.isDescriptionExpanded)
            }
        }
    }

    /** Подсчет строк в описании */
    private fun getDescriptionLineCount(isExpanded: Boolean): Int {
        return if (isExpanded) Int.MAX_VALUE else 3
    }

    /** Настройка текста показать/скрыть */
    private fun getDescriptionExpandText(isExpanded: Boolean): String {
        return getString(
            if (isExpanded) {
                R.string.movie_description_collapse
            } else {
                R.string.movie_description_expand
            }
        )
    }

}