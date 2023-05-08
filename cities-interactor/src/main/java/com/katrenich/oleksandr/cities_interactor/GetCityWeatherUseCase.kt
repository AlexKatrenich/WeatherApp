package com.katrenich.oleksandr.cities_interactor

import com.katrenich.oleksandr.base_domain.UseCase
import com.katrenich.oleksandr.cities_domain.model.CityWeatherForecastModel
import com.katrenich.oleksandr.cities_domain.repository.CitiesRepository
import javax.inject.Inject

class GetCityWeatherUseCase @Inject constructor(
	private val repository: CitiesRepository
): UseCase<Int, CityWeatherForecastModel>() {

	override suspend fun execute(parameters: Int): CityWeatherForecastModel {
		val cityModel = repository.getCityModelById(parameters)
			?: throw NoSuchElementException("There is no such city model")

		val weatherModel = repository.getWeatherModelByCity(cityModel.location)

		return CityWeatherForecastModel(
			cityModel = cityModel,
			forecastModel = weatherModel
		)
	}
}
