package com.katrenich.oleksandr.cities_presentation.ui.city_weather_details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.katrenich.oleksandr.base_presentation.ui.theme.SimpleWeatherAppTheme
import com.katrenich.oleksandr.base_presentation.ui.view.LoadingView
import com.katrenich.oleksandr.cities_domain.model.CityModel
import com.katrenich.oleksandr.cities_domain.model.CityWeatherForecastModel
import com.katrenich.oleksandr.cities_domain.model.ForecastHourModel
import com.katrenich.oleksandr.cities_domain.model.WeatherForecastModel
import com.katrenich.oleksandr.cities_presentation.state.CityWeatherState
import kotlinx.coroutines.flow.StateFlow

@Composable
fun CityWeatherDetailsScreen(
	stateFlow: StateFlow<CityWeatherState>
) {
	val state by stateFlow.collectAsStateWithLifecycle()
	val model = state.model

	if (state.isLoading || model == null) {
		LoadingView(modifier = Modifier.fillMaxSize())
	} else {
		CityWeatherDetailsView(model = model, modifier = Modifier.fillMaxSize())
	}
}

@Preview(name = "Default preview")
@Composable
fun DetailsScreenPreview() {
	SimpleWeatherAppTheme {
		CityWeatherDetailsView(
			model = getTestModel(),
			modifier = Modifier.fillMaxSize()
		)
	}
}

fun getTestModel(): CityWeatherForecastModel =
	CityWeatherForecastModel(
		cityModel = CityModel(
			id = 1,
			nameRes = com.katrenich.oleksandr.base_presentation.R.string.city_name_kyiv,
			imageRes = com.katrenich.oleksandr.base_presentation.R.drawable.kyiv
		),
		forecastModel = WeatherForecastModel(
			"18",
			weatherConditionIconLink = "https://cdn.weatherapi.com/weather/64x64/night/119.png",
			weatherConditionText = "Cloudy",
			windSpeed = "12.5",
			forecastHourModels = listOf(
				ForecastHourModel(
					"1:00",
					"https://cdn.weatherapi.com/weather/64x64/night/119.png",
					"18"
				)
			)
		)
	)