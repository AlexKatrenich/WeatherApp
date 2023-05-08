package com.katrenich.oleksandr.cities_domain.model

data class CityWeatherForecastModel(
	val cityModel: CityModel,
	val forecastModel: WeatherForecastModel
)

data class WeatherForecastModel(
	val currentTempC: String,
	val weatherConditionText: String,
	val weatherConditionIconLink: String,
	val windSpeed: String,
	val forecastHourModels: List<ForecastHourModel>
)

data class ForecastHourModel(
	val hour: String,
	val conditionWeatherIconLink: String,
	val tempC: String
)