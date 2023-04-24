package com.katrenich.oleksandr.main_data.repository

import com.katrenich.oleksandr.main_data.source.contract.MainDataSource
import com.katrenich.oleksandr.main_domain.model.CitiesModel
import com.katrenich.oleksandr.main_domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
	private val remote: MainDataSource.Remote,
	private val local: MainDataSource.Local
): MainRepository {

	override suspend fun getWeatherModelByCity(coordinates: String) =
		remote.getWeatherByCity(coordinates)

	override suspend fun getCitiesModel(): CitiesModel =
		local.getCitiesLocalModel().toCitiesModel()
}