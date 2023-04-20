package com.katrenich.oleksandr.main_presentation.view_model

import androidx.lifecycle.viewModelScope
import com.katrenich.oleksandr.base_presentation.ui.viewmodel.BaseViewModel
import com.katrenich.oleksandr.main_interactor.GetWeatherByCityUseCase
import com.katrenich.oleksandr.main_presentation.contract.CitiesViewModelContract
import com.katrenich.oleksandr.main_presentation.model.CitiesModel
import com.katrenich.oleksandr.main_presentation.model.CityModel
import com.katrenich.oleksandr.main_presentation.model.getCityModelsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
	getWeatherByCityUseCase: GetWeatherByCityUseCase
) : BaseViewModel(), CitiesViewModelContract {

	private val citiesState = MutableStateFlow(CitiesModel())

	init {
		citiesState.value = CitiesModel(getCityModelsList())
		viewModelScope.launch {
			getWeatherByCityUseCase.invoke()
		}
	}

	override fun clickOnCity(cityModel: CityModel) {

	}
}