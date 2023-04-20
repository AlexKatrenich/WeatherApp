package com.katrenich.oleksandr.main_presentation.contract

import com.katrenich.oleksandr.main_presentation.model.CityModel

interface CitiesViewModelContract {
	fun clickOnCity(cityModel: CityModel)
}