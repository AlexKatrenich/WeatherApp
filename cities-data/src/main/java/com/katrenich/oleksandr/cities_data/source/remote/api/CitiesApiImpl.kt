package com.katrenich.oleksandr.cities_data.source.remote.api

import com.katrenich.oleksandr.cities_data.source.remote.api.service.CitiesApiService
import javax.inject.Inject

class CitiesApiImpl @Inject constructor(
	private val service: CitiesApiService
) : CitiesApi {

	override suspend fun getWeatherByCityCoordinates(coordinates: String) =
		service.getForecastByCoordinates(coordinates)
}