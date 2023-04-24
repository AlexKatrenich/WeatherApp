package com.katrenich.oleksandr.main_data.source.local.cache

import com.katrenich.oleksandr.main_data.source.local.cache.model.CitiesLocalModel

interface MainCache {
	suspend fun getCitiesLocalModel(): CitiesLocalModel

}