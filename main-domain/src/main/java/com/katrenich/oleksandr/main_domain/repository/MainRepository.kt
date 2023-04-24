package com.katrenich.oleksandr.main_domain.repository

import com.katrenich.oleksandr.main_domain.model.CitiesModel

interface MainRepository {
	suspend fun getWeatherModelByCity(coordinates: String): Any
	suspend fun getCitiesModel(): CitiesModel
}