package com.katrenich.oleksandr.main_data.source.remote.api

import com.katrenich.oleksandr.main_data.source.remote.api.service.MainApiService
import javax.inject.Inject

class MainApiImpl @Inject constructor(
	private val service: MainApiService
) : MainApi {

	override suspend fun getWeatherByCityCoordinates(
		coordinates: String
	) = service.getForecastByCoordinates(coordinates)
}