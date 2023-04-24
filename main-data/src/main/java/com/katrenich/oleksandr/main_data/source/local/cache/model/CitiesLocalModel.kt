package com.katrenich.oleksandr.main_data.source.local.cache.model

import com.katrenich.oleksandr.base_presentation.R
import com.katrenich.oleksandr.main_domain.model.CitiesModel
import com.katrenich.oleksandr.main_domain.model.CityModel

data class CitiesLocalModel(
	val cities: List<CityLocalModel> = emptyList()
) {

	fun toCitiesModel(): CitiesModel =
		CitiesModel(
			cities = cities.map { it.toCityModel() }
		)
}

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