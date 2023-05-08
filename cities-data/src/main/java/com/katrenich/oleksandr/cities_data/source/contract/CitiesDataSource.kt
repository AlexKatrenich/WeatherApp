package com.katrenich.oleksandr.cities_data.source.contract

import com.katrenich.oleksandr.cities_data.source.local.cache.model.CityLocalModel
import com.katrenich.oleksandr.cities_data.source.remote.api.response.WeatherForecastResponse

interface CitiesDataSource {
	interface Remote {
		suspend fun getWeatherByCity(coordinates: String): WeatherForecastResponse
	}

	interface Local {
		suspend fun getCitiesList(): List<CityLocalModel>
		suspend fun getCityModelById(id: Int): CityLocalModel?
	}
}