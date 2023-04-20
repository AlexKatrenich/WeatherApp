package com.katrenich.oleksandr.base_data.interceptor

import com.katrenich.oleksandr.base_data.Constants
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiQueryInterceptor @Inject constructor() : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response {
		val original: Request = chain.request()
		val originalHttpUrl: HttpUrl = original.url

		val url: HttpUrl = originalHttpUrl.newBuilder()
			.addQueryParameter("key", Constants.WEATHER_API_KEY)
			.build()

		val requestBuilder: Request.Builder = original.newBuilder()
			.url(url)

		val request: Request = requestBuilder.build()
		return chain.proceed(request)
	}
}