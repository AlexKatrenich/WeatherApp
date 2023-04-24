package com.katrenich.oleksandr.main_data.source.remote.api.service

import retrofit2.http.POST
import retrofit2.http.Query

interface MainApiService {

	@POST("v1/forecast.json")
	suspend fun getForecastByCoordinates(
		@Query("q") coordinates: String // latitude and longitude like -> 50.00,50.00
	): Any

}