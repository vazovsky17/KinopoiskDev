package app.vazovsky.kinopoiskdev.extensions

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions

/** Реализация переходов с помощью NavDirections */
fun NavController.navigateSafe(direction: NavDirections, navOptions: NavOptions? = null) {
    currentDestination?.getAction(direction.actionId)?.let { navigate(direction, navOptions) }
}
