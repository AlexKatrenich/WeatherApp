package com.katrenich.oleksandr.base_di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InterceptorsModule {

  @Provides
  @Singleton
  @IntoSet
  fun loggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
    level =
      if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
  }


}