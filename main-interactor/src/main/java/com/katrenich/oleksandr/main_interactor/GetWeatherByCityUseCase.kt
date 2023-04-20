package com.katrenich.oleksandr.main_interactor

import com.katrenich.oleksandr.base_data.util.logd
import com.katrenich.oleksandr.base_domain.UseCaseWithoutParams
import com.katrenich.oleksandr.main_domain.repository.MainRepository
import javax.inject.Inject

class GetWeatherByCityUseCase @Inject constructor(
	private val repository: MainRepository
) : UseCaseWithoutParams<Unit>() {

	override suspend fun execute() {
		val test = repository.getWeatherModelByCity()
		logd("Test model: $test")
	}
}