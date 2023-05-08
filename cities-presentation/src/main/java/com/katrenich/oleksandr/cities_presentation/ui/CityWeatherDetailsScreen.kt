package com.katrenich.oleksandr.cities_presentation.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.katrenich.oleksandr.base_presentation.R
import com.katrenich.oleksandr.base_presentation.ui.theme.DetailScreenContentHeight
import com.katrenich.oleksandr.base_presentation.ui.theme.DetailsScreenImageHeight
import com.katrenich.oleksandr.base_presentation.ui.theme.SimpleWeatherAppTheme
import com.katrenich.oleksandr.base_presentation.ui.view.LoadingView
import com.katrenich.oleksandr.cities_domain.model.CityModel
import com.katrenich.oleksandr.cities_domain.model.CityWeatherForecastModel
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
		WeatherDetailsScreen(model = model, modifier = Modifier.fillMaxSize())
	}
}

@Composable
fun WeatherDetailsScreen(
	model: CityWeatherForecastModel,
	modifier: Modifier
) {
	Box(
		modifier = modifier,
		contentAlignment = Alignment.BottomCenter
	) {
		Background(
			backgroundImage = painterResource(model.cityModel.imageRes),
			backgroundColor = MaterialTheme.colors.background,
			modifier = Modifier.fillMaxSize()
		)
		DetailsWeatherView(
			model = model,
			modifier = Modifier
				.fillMaxWidth()
				.height(DetailScreenContentHeight)
		)
	}
}

@Composable
fun Background(
	backgroundImage: Painter,
	backgroundColor: Color,
	modifier: Modifier
) {
	BoxWithConstraints(
		modifier = modifier
	) {
		val width = constraints.maxWidth
		val height = constraints.maxHeight

		Image(
			painter = backgroundImage,
			contentDescription = null,
			contentScale = ContentScale.FillHeight,
			modifier = Modifier
				.fillMaxWidth()
				.height(DetailsScreenImageHeight)
		)
		Canvas(modifier = Modifier.fillMaxSize()) {
			drawCircle(
				color = backgroundColor,
				center = Offset(width * 0.2f, height * 0.9f),
				radius = height * 0.5f
			)
		}
	}
}

@Composable
fun DetailsWeatherView(
	model: CityWeatherForecastModel,
	modifier: Modifier
) {
	Column(
		modifier = modifier
	) {
		Text(
			text = stringResource(id = model.cityModel.nameRes),
			color = if (isSystemInDarkTheme()) Color.White else Color.Black,
			style = MaterialTheme.typography.h1,
			modifier = Modifier.padding(start = 32.dp)
		)
	}
}

@Preview(name = "Default preview")
@Composable
fun DetailsScreenPreview() {
	SimpleWeatherAppTheme {
		WeatherDetailsScreen(
			model = CityWeatherForecastModel(
				cityModel = CityModel(
					id = 1,
					nameRes = R.string.city_name_kyiv,
					imageRes = R.drawable.kyiv
				),
				forecastModel = WeatherForecastModel(
					"18",
					weatherConditionIconLink = "http://cdn.weatherapi.com/weather/64x64/night/119.png",
					weatherConditionText = "Cloudy",
					windSpeed = "12.5",
					forecastHourModels = emptyList()
				)
			),
			modifier = Modifier.fillMaxSize()
		)
	}
}