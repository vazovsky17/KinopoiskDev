package app.vazovsky.kinopoiskdev.presentation.film

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.databinding.FragmentFilmBinding
import app.vazovsky.kinopoiskdev.extensions.fitTopInsetsWithPadding
import app.vazovsky.kinopoiskdev.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmFragment : BaseFragment(R.layout.fragment_film) {

    private val binding by viewBinding(FragmentFilmBinding::bind)
    private val viewModel: FilmViewModel by viewModels()

    override fun callOperations() = Unit

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
    }

}