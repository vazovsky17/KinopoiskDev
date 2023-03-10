package app.vazovsky.kinopoiskdev.presentation.movie

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.databinding.FragmentMovieBinding
import app.vazovsky.kinopoiskdev.extensions.fitTopInsetsWithPadding
import app.vazovsky.kinopoiskdev.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : BaseFragment(R.layout.fragment_movie) {

    private val binding by viewBinding(FragmentMovieBinding::bind)
    private val viewModel: MovieViewModel by viewModels()

    override fun callOperations() = Unit

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
    }

}