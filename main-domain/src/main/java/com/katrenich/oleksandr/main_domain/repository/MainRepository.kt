package com.katrenich.oleksandr.main_domain.repository

interface MainRepository {
	suspend fun getWeatherModelByCity(): Any
}