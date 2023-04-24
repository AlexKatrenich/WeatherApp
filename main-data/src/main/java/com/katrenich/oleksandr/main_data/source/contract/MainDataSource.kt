package com.katrenich.oleksandr.main_data.source.contract

import com.katrenich.oleksandr.main_data.source.local.cache.model.CitiesLocalModel

interface MainDataSource {
	interface Remote {
		suspend fun getWeatherByCity(coordinates: String): Any
	}

	interface Local {
		suspend fun getCitiesLocalModel(): CitiesLocalModel

	}
}