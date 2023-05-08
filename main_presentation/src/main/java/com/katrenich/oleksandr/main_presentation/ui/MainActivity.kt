package com.katrenich.oleksandr.main_presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.katrenich.oleksandr.base_presentation.ui.theme.SimpleWeatherAppTheme
import com.katrenich.oleksandr.cities_presentation.navigation.CityWeatherDetailsScreenDestination
import com.katrenich.oleksandr.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			SimpleWeatherAppTheme {
				val systemUiController = rememberSystemUiController()
				val navController = rememberNavController()

				AppNavHost(navController = navController)

				systemUiController.setStatusBarColor(
					color = MaterialTheme.colors.background,
					darkIcons = isSystemInDarkTheme().not()
				)

				navController.addOnDestinationChangedListener { _, destination, _ ->
					changeStatusBarVisibilityByDestination(systemUiController, destination.route)
				}
			}
		}
	}

	private fun changeStatusBarVisibilityByDestination(
		systemUiController: SystemUiController,
		route: String?
	) {

		when(route) {
			CityWeatherDetailsScreenDestination.route -> systemUiController.isStatusBarVisible = false
			else -> systemUiController.isStatusBarVisible = true
		}
	}
}