package com.katrenich.oleksandr.main_domain.model

data class CitiesModel(
	val cities: List<CityModel> = emptyList()
)

data class CityModel(
	val id: Int,
	val nameRes: Int = 0,
	val imageRes: Int = 0,
	val location: String = ""
)
