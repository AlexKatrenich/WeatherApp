package com.katrenich.oleksandr.main_presentation.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.katrenich.oleksandr.base_presentation.ui.theme.*
import com.katrenich.oleksandr.main_domain.model.CitiesModel
import com.katrenich.oleksandr.main_domain.model.CityModel
import com.katrenich.oleksandr.main_presentation.view_model.CitiesViewModel

@Composable
fun CitiesScreen(
	viewModel: CitiesViewModel = viewModel()
) {
	val systemUiController: SystemUiController = rememberSystemUiController()
	systemUiController.setStatusBarColor(
		color = MaterialTheme.colors.background,
		darkIcons = isSystemInDarkTheme().not()
	)

	val citiesModel by viewModel.citiesState.collectAsStateWithLifecycle(CitiesModel())

	CitiesScreenContent(
		citiesModel = citiesModel,
		onClickAction = viewModel::clickOnCity,
		modifier = Modifier
			.fillMaxSize()
			.padding(horizontal = HorizontalPadding, vertical = VerticalPadding)
	)
}

@Composable
fun CitiesScreenContent(
	modifier: Modifier = Modifier,
	onClickAction: (CityModel) -> Unit,
	citiesModel: CitiesModel,
) {
	Surface(
		color = MaterialTheme.colors.background
	) {
		LazyColumn(modifier = modifier) {
			items(citiesModel.cities) {model ->
				CityItemView(
					model = model,
					onClickAction = onClickAction,
					modifier = Modifier
						.fillMaxWidth()
						.height(CityItemViewHeight)
						.padding(vertical = VerticalItemsPadding)
				)
			}
		}
	}
}

@Composable
fun CityItemView(
	model: CityModel,
	onClickAction: (CityModel) -> Unit,
	modifier: Modifier
) {
	Surface(
		modifier = modifier,
		shape = RoundedCornerShape(MediumCornerSize),
		color = MaterialTheme.colors.surface,
		elevation = SmallElevation
	) {
		Box(
			modifier = Modifier
				.clickable { onClickAction(model) },
			contentAlignment = Alignment.TopStart
		) {
			Image(
				painter = painterResource(model.imageRes),
				contentDescription = null,
				modifier = Modifier.fillMaxSize(),
				contentScale = ContentScale.FillBounds
			)
			Text(
				text = stringResource(model.nameRes),
				style = MaterialTheme.typography.h1.copy(color = Color.Black),
				modifier = Modifier.padding(start = HorizontalPadding)
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PreviewCityItemView() {
	SimpleWeatherAppTheme {
		CityItemView(
			model = CityModel(
				1,
				com.katrenich.oleksandr.base_presentation.R.string.city_name_kharkiv,
				com.katrenich.oleksandr.base_presentation.R.drawable.kharkiv
			),
			onClickAction = {},
			modifier = Modifier
				.fillMaxWidth()
				.height(CityItemViewHeight)
		)
	}
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewCitiesScreen() {
	SimpleWeatherAppTheme {
		CitiesScreen()
	}
}