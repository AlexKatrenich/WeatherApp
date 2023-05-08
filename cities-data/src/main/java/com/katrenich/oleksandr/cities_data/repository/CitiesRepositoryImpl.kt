package com.katrenich.oleksandr.cities_data.repository

import com.katrenich.oleksandr.cities_data.source.contract.CitiesDataSource
import com.katrenich.oleksandr.cities_data.source.remote.api.response.toDomainModel
import com.katrenich.oleksandr.cities_domain.model.CityModel
import com.katrenich.oleksandr.cities_domain.repository.CitiesRepository
import javax.inject.Inject

class CitiesRepositoryImpl @Inject constructor(
	private val remote: CitiesDataSource.Remote,
	private val local: CitiesDataSource.Local
) : CitiesRepository {

	override suspend fun getCitiesModel(): List<CityModel> =
		local.getCitiesList().map { it.toCityModel() }

	override suspend fun getCityModelById(id: Int): CityModel? =
		local.getCityModelById(id)?.toCityModel()

	override suspend fun getWeatherModelByCity(coordinates: String) =
		remote.getWeatherByCity(coordinates).toDomainModel()
}