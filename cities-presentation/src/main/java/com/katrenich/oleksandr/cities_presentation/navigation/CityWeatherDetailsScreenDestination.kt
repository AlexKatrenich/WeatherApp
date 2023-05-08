package com.katrenich.oleksandr.cities_presentation.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.katrenich.oleksandr.base_navigation.BaseDestination

object CityWeatherDetailsScreenDestination : BaseDestination() {
	const val CityWeatherDetailsPath: String = "city_weather_details"
	const val CityIdNavArgument: String = "cityId"

	override val route = "$CityWeatherDetailsPath/{$CityIdNavArgument}"

	override val arguments = listOf(navArgument(CityIdNavArgument) { type = NavType.IntType })

}