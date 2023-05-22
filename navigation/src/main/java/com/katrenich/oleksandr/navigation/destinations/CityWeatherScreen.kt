package com.katrenich.oleksandr.navigation.destinations

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.katrenich.oleksandr.base_navigation.extensions.navigationTo
import com.katrenich.oleksandr.cities_presentation.navigation.CityWeatherDetailsScreenDestination
import com.katrenich.oleksandr.cities_presentation.ui.city_weather_details.CityWeatherDetailsScreen
import com.katrenich.oleksandr.cities_presentation.view_model.CityWeatherDetailsViewModel

fun NavHostController.navigateToCityWeatherDetails(cityId: Int) {
	navigate("${CityWeatherDetailsScreenDestination.CityWeatherDetailsPath}/$cityId")
}

fun NavGraphBuilder.navigationToCityWeatherDetails() {
	navigationTo(CityWeatherDetailsScreenDestination) {
		val viewModel = hiltViewModel<CityWeatherDetailsViewModel>()

		CityWeatherDetailsScreen(
			viewModel.cityDetailsState
		)
	}
}