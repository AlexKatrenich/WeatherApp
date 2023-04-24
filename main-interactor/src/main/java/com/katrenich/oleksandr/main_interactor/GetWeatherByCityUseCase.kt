package com.katrenich.oleksandr.main_interactor

import com.katrenich.oleksandr.base_domain.UseCase
import com.katrenich.oleksandr.main_domain.model.CityModel
import com.katrenich.oleksandr.main_domain.repository.MainRepository
import javax.inject.Inject

class GetWeatherByCityUseCase @Inject constructor(
	private val repository: MainRepository
) : UseCase<CityModel, Any>() {

	override suspend fun execute(parameters: CityModel): Any {
		val cityCoordinates = parameters.location
		return repository.getWeatherModelByCity(cityCoordinates)
	}
}