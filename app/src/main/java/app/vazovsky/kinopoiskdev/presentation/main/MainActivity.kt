package app.vazovsky.kinopoiskdev.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.databinding.ActivityMainBinding
import app.vazovsky.kinopoiskdev.extensions.observeNavigationCommands
import app.vazovsky.kinopoiskdev.presentation.base.BaseActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands(this, R.id.navHostFragment)
    }
}