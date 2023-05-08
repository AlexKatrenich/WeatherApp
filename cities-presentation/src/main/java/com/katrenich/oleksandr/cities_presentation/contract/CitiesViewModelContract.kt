package com.katrenich.oleksandr.cities_presentation.contract

import com.katrenich.oleksandr.cities_presentation.state.CitiesState
import kotlinx.coroutines.flow.StateFlow

interface CitiesViewModelContract {
	val citiesState: StateFlow<CitiesState>
}