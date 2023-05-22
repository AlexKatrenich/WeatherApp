package com.katrenich.oleksandr.cities_presentation.ui.city_weather_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.size.Dimension
import com.katrenich.oleksandr.base_presentation.ui.theme.*
import com.katrenich.oleksandr.cities_domain.model.CityWeatherForecastModel
import com.katrenich.oleksandr.cities_domain.model.WeatherForecastModel
import com.katrenich.oleksandr.cities_presentation.R

@Composable
fun CityWeatherDetailsView(
	model: CityWeatherForecastModel,
	modifier: Modifier
) {
	Box(
		modifier = modifier,
		contentAlignment = Alignment.BottomCenter
	) {
		BackgroundView(
			backgroundImage = painterResource(model.cityModel.imageRes),
			backgroundColor = MaterialTheme.colors.background,
			modifier = Modifier.fillMaxSize()
		)
		WeatherDetailsView(
			model = model,
			modifier = Modifier
				.fillMaxWidth()
				.height(DetailScreenContentHeight)
		)
	}
}

@Composable
private fun WeatherDetailsView(
	model: CityWeatherForecastModel,
	modifier: Modifier
) {
	Column(
		modifier = modifier
	) {
		CityTitleView(
			cityNameRes = model.cityModel.nameRes
		)
		WeatherInfoView(
			forecastModel = model.forecastModel,
			modifier = Modifier
				.fillMaxWidth()
				.weight(0.5f)
				.padding(top = VerticalMediumPadding)
		)
		LazyRow(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Center,
			modifier = Modifier
				.fillMaxWidth()
				.weight(1f)
				.padding(
					start = HorizontalSmallPadding,
					end = HorizontalSmallPadding,
					bottom = VerticalLargePadding
				)
		) {
			items(items = model.forecastModel.forecastHourModels) {model ->
				WeatherForecastItemView(model = model)
			}
		}
	}
}

@Composable
private fun CityTitleView(
	cityNameRes: Int,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.Bottom
	) {
		Image(
			painter = painterResource(
				id = R.drawable.ic_location
			),
			contentDescription = null,
			contentScale = ContentScale.Fit,
			modifier = Modifier
				.size(IconMediumSize)
				.padding(bottom = HorizontalSmallPadding)
		)
		Text(
			text = stringResource(id = cityNameRes),
			color = if (isSystemInDarkTheme()) Color.White else Color.Black,
			style = MaterialTheme.typography.h1
		)
	}
}

@Composable
private fun WeatherInfoView(
	forecastModel: WeatherForecastModel,
	modifier: Modifier
) {
	Row(
		modifier = modifier,
		horizontalArrangement = Arrangement.Center,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = forecastModel.currentTempC,
			color = if (isSystemInDarkTheme()) Color.White else Color.Black,
			style = MaterialTheme.typography.h2.copy(fontSize = TemperatureFontSize),
			modifier = Modifier.padding(start = HorizontalMediumPadding)
		)
		Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.padding(start = HorizontalSmallPadding)) {
			WeatherConditionView(
				weatherConditionText = forecastModel.weatherConditionText,
				weatherConditionIconLink = forecastModel.weatherConditionIconLink,
				modifier = Modifier.padding(bottom = VerticalSmallPadding)
			)
			WindConditionView(
				windSpeed = forecastModel.windSpeed,
				modifier = Modifier
			)
			Spacer(modifier = Modifier.height(VerticalMediumPadding))
		}
	}
}

@Composable
private fun WeatherConditionView(
	weatherConditionText: String,
	weatherConditionIconLink: String,
	modifier: Modifier = Modifier
) {
	Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
		AsyncImage(
			model = weatherConditionIconLink,
			contentDescription = null,
			contentScale = ContentScale.Fit,
			modifier = Modifier.size(IconSmallSize)
		)
		Text(
			text = weatherConditionText,
			style = MaterialTheme.typography.caption,
			color = if (isSystemInDarkTheme()) Color.White else Color.Black,
			modifier = Modifier.padding(start = HorizontalSmallPadding)
		)
	}
}

@Composable
private fun WindConditionView(
	windSpeed: String,
	modifier: Modifier = Modifier
) {
	Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
		Image(
			painter = painterResource(id = R.drawable.ic_wind),
			contentDescription = null,
			contentScale = ContentScale.Fit,
			modifier = Modifier.size(IconSmallSize)
		)
		Text(
			text = windSpeed,
			style = MaterialTheme.typography.caption,
			color = if (isSystemInDarkTheme()) Color.White else Color.Black,
			modifier = Modifier.padding(start = HorizontalSmallPadding)
		)
	}
}

@Preview(name = "WeatherInfoView preview")
@Composable
fun WeatherInfoViewPreview() {
	WeatherDetailsView(
		model = getTestModel(),
		modifier = Modifier.fillMaxSize()
	)
}