package com.katrenich.oleksandr.cities_data.source.remote.api.service

import com.katrenich.oleksandr.cities_data.source.remote.api.response.WeatherForecastResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface CitiesApiService {

	@POST("v1/forecast.json")
	suspend fun getForecastByCoordinates(
		@Query("q") coordinates: String // latitude and longitude like -> 50.00,50.00
	): WeatherForecastResponse
}