package com.katrenich.oleksandr.main_interactor

import com.katrenich.oleksandr.base_domain.UseCaseWithoutParams
import com.katrenich.oleksandr.main_domain.model.CitiesModel
import com.katrenich.oleksandr.main_domain.repository.MainRepository
import javax.inject.Inject

class GetCitiesModelUseCase @Inject constructor(
	private val repository: MainRepository
)
	: UseCaseWithoutParams<CitiesModel>() {

	override suspend fun execute(): CitiesModel =
		repository.getCitiesModel()

}