package com.katrenich.oleksandr.cities_presentation.view_model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katrenich.oleksandr.base_domain.onError
import com.katrenich.oleksandr.base_domain.onSuccess
import com.katrenich.oleksandr.cities_interactor.GetCityWeatherUseCase
import com.katrenich.oleksandr.cities_presentation.contract.CityWeatherDetailsViewModelContract
import com.katrenich.oleksandr.cities_presentation.navigation.CityWeatherDetailsScreenDestination
import com.katrenich.oleksandr.cities_presentation.state.CityWeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityWeatherDetailsViewModel @Inject constructor(
		private val getCityWeatherUseCase: GetCityWeatherUseCase,
		savedStateHandle: SavedStateHandle
) : ViewModel(), CityWeatherDetailsViewModelContract {

	private val _cityDetailsState = MutableStateFlow(CityWeatherState(isLoading = true))

	val cityDetailsState: StateFlow<CityWeatherState> = _cityDetailsState.asStateFlow()

	private val cityId: Int = savedStateHandle[CityWeatherDetailsScreenDestination.CityIdNavArgument]
		?: throw IllegalArgumentException()

	init {
		viewModelScope.launch {
			getCityWeatherUseCase(cityId)
				.onError { it.printStackTrace() }
				.onSuccess {
					_cityDetailsState.value = CityWeatherState(
						model = it,
						isLoading = false
					)
				}
		}
	}
}