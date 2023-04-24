package com.katrenich.oleksandr.main_presentation.view_model

import androidx.lifecycle.viewModelScope
import com.katrenich.oleksandr.base_domain.onSuccess
import com.katrenich.oleksandr.base_presentation.ui.utils.logd
import com.katrenich.oleksandr.base_presentation.ui.viewmodel.BaseViewModel
import com.katrenich.oleksandr.main_domain.model.CitiesModel
import com.katrenich.oleksandr.main_domain.model.CityModel
import com.katrenich.oleksandr.main_interactor.GetCitiesModelUseCase
import com.katrenich.oleksandr.main_interactor.GetWeatherByCityUseCase
import com.katrenich.oleksandr.main_presentation.contract.CitiesViewModelContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
	getCitiesModelUseCase: GetCitiesModelUseCase,
	private val getWeatherByCityUseCase: GetWeatherByCityUseCase
) : BaseViewModel(), CitiesViewModelContract {

	private val _citiesState = MutableStateFlow(CitiesModel())
	override val citiesState: StateFlow<CitiesModel> = _citiesState.asStateFlow()

	init {
		viewModelScope.launch {
			getCitiesModelUseCase().onSuccess { _citiesState.value = it }
		}
	}

	override fun clickOnCity(cityModel: CityModel) {
		viewModelScope.launch {
			val test = getWeatherByCityUseCase(parameters = cityModel)
			logd("Test city weather")
		}
	}
}