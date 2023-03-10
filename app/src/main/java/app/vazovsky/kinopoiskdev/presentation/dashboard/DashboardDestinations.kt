package app.vazovsky.kinopoiskdev.presentation.dashboard

import app.vazovsky.kinopoiskdev.presentation.base.NavigationCommand
import javax.inject.Inject

class DashboardDestinations @Inject constructor() {

    fun movie() = NavigationCommand.To(
        DashboardFragmentDirections.actionDashboardFragmentToMovieFragment()
    )

}