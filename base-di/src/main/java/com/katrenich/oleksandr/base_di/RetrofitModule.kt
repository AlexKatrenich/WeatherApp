package com.katrenich.oleksandr.base_di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

  @Provides
  @Singleton
  fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
    return GsonConverterFactory.create(gson)
  }

  @Provides
  @Singleton
  @Named("Default")
  fun provideDefaultRetrofit(
    @Named("Default") httpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
  ): Retrofit {
    return Retrofit.Builder().apply {
      baseUrl(BuildConfig.BASE_URL)
      addConverterFactory(gsonConverterFactory)
      client(httpClient)
    }.build()
  }
}
