package com.katrenich.oleksandr.cities_presentation.state

import com.katrenich.oleksandr.cities_domain.model.CityWeatherForecastModel

data class CityWeatherState(
	val model: CityWeatherForecastModel? = null,
	val isLoading: Boolean = false
)
