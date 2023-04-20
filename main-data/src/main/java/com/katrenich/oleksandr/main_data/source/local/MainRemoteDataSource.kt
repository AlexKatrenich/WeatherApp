package com.katrenich.oleksandr.main_data.source.local

import com.katrenich.oleksandr.main_data.source.contract.MainDataSource
import com.katrenich.oleksandr.main_data.source.remote.api.MainApi
import javax.inject.Inject

class MainRemoteDataSource @Inject constructor(
	private val api: MainApi
) : MainDataSource.Remote {
	override suspend fun getWeatherByCity() = api.getWeatherByCity()
}