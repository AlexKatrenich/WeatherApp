package com.katrenich.oleksandr.cities_data.source.local.cache

import com.katrenich.oleksandr.cities_data.source.local.cache.model.CityLocalModel
import com.katrenich.oleksandr.cities_data.source.local.cache.singleton.CitiesDataSingleton
import javax.inject.Inject

class CitiesCacheImpl @Inject constructor() : CitiesCache {

	override suspend fun getCitiesList(): List<CityLocalModel> =
		CitiesDataSingleton.getCitiesList()

	override suspend fun getCityById(id: Int): CityLocalModel? =
		CitiesDataSingleton.getCitiesList().find { it.id == id }
}