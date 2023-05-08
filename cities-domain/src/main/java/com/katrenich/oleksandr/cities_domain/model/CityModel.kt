package com.katrenich.oleksandr.cities_domain.model

data class CityModel(
	val id: Int,
	val nameRes: Int = 0,
	val imageRes: Int = 0,
	val location: String = ""
)