package com.katrenich.oleksandr.cities_data.source.local

import com.katrenich.oleksandr.cities_data.source.contract.CitiesDataSource
import com.katrenich.oleksandr.cities_data.source.local.cache.CitiesCache
import com.katrenich.oleksandr.cities_data.source.local.cache.model.CityLocalModel
import javax.inject.Inject

class CitiesLocalDataSource @Inject constructor(
	private val citiesCache: CitiesCache
) : CitiesDataSource.Local {

	override suspend fun getCitiesList(): List<CityLocalModel> =
		citiesCache.getCitiesList()

	override suspend fun getCityModelById(id: Int): CityLocalModel? =
		citiesCache.getCityById(id)
}