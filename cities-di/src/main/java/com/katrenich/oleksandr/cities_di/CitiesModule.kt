package com.katrenich.oleksandr.cities_di

import com.katrenich.oleksandr.cities_data.repository.CitiesRepositoryImpl
import com.katrenich.oleksandr.cities_data.source.contract.CitiesDataSource
import com.katrenich.oleksandr.cities_data.source.local.CitiesLocalDataSource
import com.katrenich.oleksandr.cities_data.source.local.cache.CitiesCache
import com.katrenich.oleksandr.cities_data.source.local.cache.CitiesCacheImpl
import com.katrenich.oleksandr.cities_data.source.remote.CitiesRemoteDataSource
import com.katrenich.oleksandr.cities_data.source.remote.api.CitiesApi
import com.katrenich.oleksandr.cities_data.source.remote.api.CitiesApiImpl
import com.katrenich.oleksandr.cities_data.source.remote.api.service.CitiesApiService
import com.katrenich.oleksandr.cities_domain.repository.CitiesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CitiesModule {

	@Binds
	@Singleton
	abstract fun citiesRepository(impl: CitiesRepositoryImpl): CitiesRepository

	@Binds
	@Singleton
	abstract fun citiesRemoteDataSource(impl: CitiesRemoteDataSource): CitiesDataSource.Remote

	@Binds
	@Singleton
	abstract fun citiesLocalDataSource(impl: CitiesLocalDataSource): CitiesDataSource.Local

	@Binds
	@Singleton
	abstract fun citiesApi(impl: CitiesApiImpl): CitiesApi

	@Binds
	@Singleton
	abstract fun citiesCache(impl: CitiesCacheImpl): CitiesCache

	companion object {
		@Provides
		@Singleton
		fun provideCitiesService(@Named("Default") restAdapter: Retrofit): CitiesApiService =
			restAdapter.create(CitiesApiService::class.java)
	}
}