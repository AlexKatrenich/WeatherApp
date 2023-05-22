package com.katrenich.oleksandr.cities_data.source.remote.api.response

import com.katrenich.oleksandr.cities_domain.model.ForecastHourModel
import com.katrenich.oleksandr.cities_domain.model.WeatherForecastModel
import java.text.SimpleDateFormat
import java.util.*

data class WeatherForecastResponse(
	val current: CurrentWeatherResponse,
	val forecast: ForecastResponse
)

data class CurrentWeatherResponse(
	val temp_c: String,
	val condition: ConditionResponse,
	val wind_kph: String
)

data class ConditionResponse(
	val text: String,
	val icon: String
)

data class ForecastResponse(
	val forecastday: List<ForecastDayResponse>
)

data class ForecastDayResponse(
	val hour: List<HourForecastResponse>
)

data class HourForecastResponse(
	val condition: ConditionResponse,
	val time_epoch: Long,
	val temp_c: String
)

fun WeatherForecastResponse.toDomainModel() =
	WeatherForecastModel(
		currentTempC = "${current.temp_c}°",
		weatherConditionText = current.condition.text,
		weatherConditionIconLink = "https://${current.condition.icon}",
		windSpeed = current.wind_kph,
		forecastHourModels = forecast.forecastday
			.firstOrNull()
			?.hour
			?.map { it.toDomainModel() }
			?.filterIndexed { index, _ -> index % 5 == 1 }
			?: emptyList()
	)

fun HourForecastResponse.toDomainModel(): ForecastHourModel {
	val sdf = SimpleDateFormat("HH", Locale.getDefault())
	val date = Date(time_epoch * 1000)

	return ForecastHourModel(
		hour = sdf.format(date) + ":00",
		conditionWeatherIconLink = "https://${condition.icon}",
		tempC = "$temp_c°"
	)
}