package com.katrenich.oleksandr.main_di

import com.katrenich.oleksandr.main_data.repository.MainRepositoryImpl
import com.katrenich.oleksandr.main_data.source.contract.MainDataSource
import com.katrenich.oleksandr.main_data.source.remote.MainRemoteDataSource
import com.katrenich.oleksandr.main_data.source.local.MainLocalDataSource
import com.katrenich.oleksandr.main_data.source.local.cache.MainCache
import com.katrenich.oleksandr.main_data.source.local.cache.MainCacheImpl
import com.katrenich.oleksandr.main_data.source.remote.api.MainApi
import com.katrenich.oleksandr.main_data.source.remote.api.MainApiImpl
import com.katrenich.oleksandr.main_data.source.remote.api.service.MainApiService
import com.katrenich.oleksandr.main_domain.repository.MainRepository
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
abstract class MainModule {

	@Binds
	@Singleton
	abstract fun mainRepository(impl: MainRepositoryImpl): MainRepository

	@Binds
	@Singleton
	abstract fun mainRemoteDataSource(impl: MainRemoteDataSource): MainDataSource.Remote

	@Binds
	@Singleton
	abstract fun mainLocalDataSource(impl: MainLocalDataSource): MainDataSource.Local

	@Binds
	@Singleton
	abstract fun mainApi(impl: MainApiImpl): MainApi

	@Binds
	@Singleton
	abstract fun mainCache(impl: MainCacheImpl): MainCache

	companion object {
		@Provides
		@Singleton
		fun provideMainService(@Named("Default") restAdapter: Retrofit): MainApiService =
			restAdapter.create(MainApiService::class.java)
	}
}