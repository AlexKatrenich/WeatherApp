package com.katrenich.oleksandr.cities_data.source.local.cache.model

import com.katrenich.oleksandr.cities_domain.model.CityModel

data class CityLocalModel(
	val id: Int,
	val nameRes: Int = 0,
	val imageRes: Int = 0,
	val location: String
) {

	fun toCityModel(): CityModel =
		CityModel(
			id = id,
			nameRes = nameRes,
			imageRes = imageRes,
			location = location
		)
}