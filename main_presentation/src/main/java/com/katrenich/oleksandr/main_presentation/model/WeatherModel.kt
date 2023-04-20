package com.katrenich.oleksandr.main_presentation.model

import androidx.annotation.DrawableRes

data class WeatherModel(
	val cityName: String,
	@DrawableRes val cityImageRes: Int,
	val temperature: String,
	val weatherStatus: String,
	@DrawableRes val weatherIcon: Int,
	val dayPeriod: DayPeriod,
	val days5Forecast: List<WeatherForecastModel>
)

data class WeatherForecastModel(
	val dayNumber: String,
	val weatherIcon: Int,
	val temperature: String
)

enum class DayPeriod {
	MORNING, DAY, EVENING, NIGHT
}
