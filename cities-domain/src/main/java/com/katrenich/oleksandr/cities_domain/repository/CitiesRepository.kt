package com.katrenich.oleksandr.cities_domain.repository

import com.katrenich.oleksandr.cities_domain.model.CityModel
import com.katrenich.oleksandr.cities_domain.model.WeatherForecastModel

interface CitiesRepository {
	suspend fun getCitiesModel(): List<CityModel>
	suspend fun getCityModelById(id: Int): CityModel?
	suspend fun getWeatherModelByCity(coordinates: String): WeatherForecastModel
}