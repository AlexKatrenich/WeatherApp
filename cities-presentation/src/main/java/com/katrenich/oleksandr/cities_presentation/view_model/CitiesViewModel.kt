package com.katrenich.oleksandr.cities_presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katrenich.oleksandr.base_domain.onSuccess
import com.katrenich.oleksandr.cities_interactor.GetCitiesListUseCase
import com.katrenich.oleksandr.cities_presentation.contract.CitiesViewModelContract
import com.katrenich.oleksandr.cities_presentation.state.CitiesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
	getCitiesListUseCase: GetCitiesListUseCase
) : ViewModel(), CitiesViewModelContract {

	private val _citiesState = MutableStateFlow(CitiesState())
	override val citiesState: StateFlow<CitiesState> = _citiesState.asStateFlow()

	init {
		viewModelScope.launch {
			getCitiesListUseCase().onSuccess { _citiesState.value = CitiesState(citiesList = it) }
		}
	}

}