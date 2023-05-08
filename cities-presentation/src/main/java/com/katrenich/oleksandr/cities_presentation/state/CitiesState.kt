package com.katrenich.oleksandr.cities_presentation.state

import com.katrenich.oleksandr.cities_domain.model.CityModel

data class CitiesState(
	val citiesList: List<CityModel> = emptyList()
)