package com.katrenich.oleksandr.cities_interactor

import com.katrenich.oleksandr.base_domain.UseCaseWithoutParams
import com.katrenich.oleksandr.cities_domain.model.CityModel
import com.katrenich.oleksandr.cities_domain.repository.CitiesRepository
import javax.inject.Inject

class GetCitiesListUseCase @Inject constructor(
	private val repository: CitiesRepository
) : UseCaseWithoutParams<List<CityModel>>() {

	override suspend fun execute(): List<CityModel> =
		repository.getCitiesModel()
}