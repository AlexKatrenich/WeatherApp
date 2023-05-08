package com.katrenich.oleksandr.cities_data.source.remote

import com.katrenich.oleksandr.cities_data.source.contract.CitiesDataSource
import com.katrenich.oleksandr.cities_data.source.remote.api.CitiesApi
import com.katrenich.oleksandr.cities_data.source.remote.api.response.WeatherForecastResponse
import javax.inject.Inject

class CitiesRemoteDataSource @Inject constructor(
	private val api: CitiesApi
) : CitiesDataSource.Remote {

	override suspend fun getWeatherByCity(coordinates: String) =
		api.getWeatherByCityCoordinates(coordinates)
}