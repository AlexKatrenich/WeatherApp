package com.katrenich.oleksandr.cities_presentation.ui.city_weather_details

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.katrenich.oleksandr.base_presentation.ui.theme.HorizontalSmallPadding
import com.katrenich.oleksandr.base_presentation.ui.theme.IconSmallSize
import com.katrenich.oleksandr.base_presentation.ui.theme.SimpleWeatherAppTheme
import com.katrenich.oleksandr.cities_domain.model.ForecastHourModel

@Composable
internal fun WeatherForecastItemView(
	model: ForecastHourModel,
	modifier: Modifier = Modifier
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = modifier.padding(horizontal = HorizontalSmallPadding)
	) {
		Text(
			text = model.hour,
			style = MaterialTheme.typography.h3,
			color = if (isSystemInDarkTheme()) Color.White else Color.Black
		)
		AsyncImage(
			model = model.conditionWeatherIconLink,
			contentDescription = null,
			modifier = Modifier.size(IconSmallSize).padding(top = 4.dp)
		)
		Text(
			text = model.tempC,
			style = MaterialTheme.typography.h3,
			color = if (isSystemInDarkTheme()) Color.White else Color.Black,
			modifier = Modifier.padding(top = 4.dp)
		)
	}
}

@Preview(name = "WeatherForecastItemViewPreview")
@Composable
fun WeatherForecastItemViewPreview() {
	SimpleWeatherAppTheme {
		WeatherForecastItemView(
			model = getTestModel().forecastModel.forecastHourModels.first()
		)
	}
}