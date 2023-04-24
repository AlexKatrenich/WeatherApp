package com.katrenich.oleksandr.main_data.source.local.cache

import com.katrenich.oleksandr.main_data.source.local.cache.model.CitiesLocalModel
import com.katrenich.oleksandr.main_data.source.local.cache.singleton.MainDataSingleton
import javax.inject.Inject

class MainCacheImpl @Inject constructor(
): MainCache {

	override suspend fun getCitiesLocalModel(): CitiesLocalModel =
		CitiesLocalModel(
			cities = MainDataSingleton.getCitiesList()
		)
}