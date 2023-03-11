package app.vazovsky.kinopoiskdev.presentation.dashboard

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.databinding.FragmentDashboardBinding
import app.vazovsky.kinopoiskdev.extensions.addDefaultGridSpaceItemDecoration
import app.vazovsky.kinopoiskdev.extensions.addLinearSpaceItemDecoration
import app.vazovsky.kinopoiskdev.extensions.fitTopInsetsWithPadding
import app.vazovsky.kinopoiskdev.extensions.hideSoftKeyboard
import app.vazovsky.kinopoiskdev.presentation.base.BaseFragment
import app.vazovsky.kinopoiskdev.presentation.dashboard.movies.MoviesAdapter
import app.vazovsky.kinopoiskdev.presentation.dashboard.tabs.TabsAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/** Главный экран */
@AndroidEntryPoint
class DashboardFragment : BaseFragment(R.layout.fragment_dashboard) {

    private val binding by viewBinding(FragmentDashboardBinding::bind)
    private val viewModel: DashboardViewModel by viewModels()

    @Inject lateinit var tabsAdapter: TabsAdapter
    @Inject lateinit var moviesAdapter: MoviesAdapter

    override fun callOperations() {
        viewModel.getGenres()
    }

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()

        setupTabs()
        setupMovies()
        setupSearch()
        stateViewFlipper.setRetryMethod { viewModel.getMovies() }
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
        genresLiveData.observe { }
        genresFiltersLiveData.observe { filters ->
            tabsAdapter.submitList(filters)
        }
        moviesLiveData.observe { result ->
            binding.stateViewFlipper.setStateFromResult(result)
            result.doOnSuccess { movies ->
                moviesAdapter.submitList(movies)
                bindTitle(movies.isEmpty())
            }
        }
    }

    /** Настройка поиска */
    private fun setupSearch() = with(binding) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getMovies(name = query)
                searchView.hideSoftKeyboard()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = true
        })
        searchView.setOnCloseListener {
            viewModel.getMovies()
            searchView.hideSoftKeyboard()
            true
        }
    }

    /** Настройка фильтров */
    private fun setupTabs() = with(binding) {
        recyclerViewMovies.emptyView = emptyViewMovies
        recyclerViewTabs.adapter = tabsAdapter.apply {
            onItemClick = { tab, position ->
                val newTab = tab.copy(isSelected = !tab.isSelected)
                updateItem(newTab, position)
                viewModel.updateGenres(newTab)
            }
        }
        recyclerViewTabs.addLinearSpaceItemDecoration(
            spacing = R.dimen.padding_12,
            showFirstVerticalDivider = true,
            showLastVerticalDivider = true,
        )
    }

    /** Настройка списка фильмов */
    private fun setupMovies() = with(binding) {
        recyclerViewMovies.adapter = moviesAdapter.apply {
            onItemClick = { movie ->
                viewModel.openMovie(movie.id.toString())
            }
        }
        recyclerViewMovies.addDefaultGridSpaceItemDecoration(
            spanCount = 2,
            spacing = R.dimen.padding_12,
            includeEdge = true,
        )
    }

    private fun bindTitle(isMoviesEmpty: Boolean) = with(binding.textViewTitle) {
        text = getString(
            if (isMoviesEmpty) R.string.dashboard_title_empty
            else R.string.dashboard_title
        )
    }

}