package com.katrenich.oleksandr.main_data.source.remote.api

interface MainApi {
	suspend fun getWeatherByCity(): Any
}