package com.katrenich.oleksandr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.katrenich.oleksandr.cities_presentation.navigation.CitiesScreenDestination
import com.katrenich.oleksandr.navigation.destinations.navigationToCitiesScreen
import com.katrenich.oleksandr.navigation.destinations.navigationToCityWeatherDetails

@Composable
fun AppNavHost(
	navController: NavHostController
) {
	NavHost(navController = navController, startDestination = CitiesScreenDestination.route) {
		navigationToCitiesScreen(navController = navController)
		navigationToCityWeatherDetails()
	}
}

