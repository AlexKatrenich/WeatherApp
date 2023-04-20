package com.katrenich.oleksandr.main_data.source.remote.api.service

import retrofit2.http.POST

interface MainApiService {

	@POST("v1/forecast.json")
	suspend fun getForecastByCoordinates(

	): Any

}