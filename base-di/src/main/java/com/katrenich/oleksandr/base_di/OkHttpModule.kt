package com.katrenich.oleksandr.base_di

import com.katrenich.oleksandr.base_data.interceptor.ApiQueryInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkHttpModule {

  @Singleton
  @Provides
  @Named("Default")
  fun provideHttpClient(
    interceptorsSet: Set<@JvmSuppressWildcards Interceptor>,
    interceptor: ApiQueryInterceptor
  ): OkHttpClient {
    val builder = OkHttpClient.Builder().also { client ->
      client.readTimeout(20, TimeUnit.SECONDS)
      interceptorsSet.forEach { client.addInterceptor(it) }
      client.addInterceptor(interceptor)
      client.followRedirects(true)
    }
    return builder.build()
  }
}
