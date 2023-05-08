package com.katrenich.oleksandr.cities_data.source.remote.api

import com.katrenich.oleksandr.cities_data.source.remote.api.response.WeatherForecastResponse

interface CitiesApi {
	suspend fun getWeatherByCityCoordinates(coordinates: String): WeatherForecastResponse
}