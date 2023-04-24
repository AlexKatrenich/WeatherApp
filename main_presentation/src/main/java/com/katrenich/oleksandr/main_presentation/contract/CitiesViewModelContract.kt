package com.katrenich.oleksandr.main_presentation.contract

import com.katrenich.oleksandr.main_domain.model.CitiesModel
import com.katrenich.oleksandr.main_domain.model.CityModel
import kotlinx.coroutines.flow.StateFlow

interface CitiesViewModelContract {
	val citiesState: StateFlow<CitiesModel>

	fun clickOnCity(cityModel: CityModel)
}