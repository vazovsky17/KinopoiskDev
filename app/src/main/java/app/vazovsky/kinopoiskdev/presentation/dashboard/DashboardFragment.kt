package app.vazovsky.kinopoiskdev.presentation.dashboard

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.databinding.FragmentDashboardBinding
import app.vazovsky.kinopoiskdev.extensions.fitTopInsetsWithPadding
import app.vazovsky.kinopoiskdev.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment(R.layout.fragment_dashboard) {

    private val binding by viewBinding(FragmentDashboardBinding::bind)
    private val viewModel: DashboardViewModel by viewModels()

    override fun callOperations() = Unit

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
    }

}