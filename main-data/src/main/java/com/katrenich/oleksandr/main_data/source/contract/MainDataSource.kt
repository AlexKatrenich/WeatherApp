package com.katrenich.oleksandr.main_data.source.contract

interface MainDataSource {
	interface Remote {
		suspend fun getWeatherByCity(coordinates: String): Any
	}

	interface Local {

	}
}