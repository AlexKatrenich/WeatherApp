package com.katrenich.oleksandr.cities_data.source.local.cache

import com.katrenich.oleksandr.cities_data.source.local.cache.model.CityLocalModel

interface CitiesCache {
	suspend fun getCitiesList(): List<CityLocalModel>
	suspend fun getCityById(id: Int): CityLocalModel?
}