package com.katrenich.oleksandr.navigation.destinations

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.katrenich.oleksandr.base_navigation.extensions.navigationTo
import com.katrenich.oleksandr.cities_presentation.navigation.CitiesScreenDestination
import com.katrenich.oleksandr.cities_presentation.ui.CitiesScreen
import com.katrenich.oleksandr.cities_presentation.view_model.CitiesViewModel

fun NavGraphBuilder.navigationToCitiesScreen(
	navController: NavHostController
) {
	navigationTo(CitiesScreenDestination) {
		val citiesViewModel = hiltViewModel<CitiesViewModel>()

		CitiesScreen(
			citiesState = citiesViewModel.citiesState,
			navigateToCitiDetails = navController::navigateToCityWeatherDetails
		)
	}
}