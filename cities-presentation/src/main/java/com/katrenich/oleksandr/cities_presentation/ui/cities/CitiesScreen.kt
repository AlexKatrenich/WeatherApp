package com.katrenich.oleksandr.cities_presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.katrenich.oleksandr.base_presentation.ui.theme.*
import com.katrenich.oleksandr.cities_domain.model.CityModel
import com.katrenich.oleksandr.cities_presentation.state.CitiesState
import com.katrenich.oleksandr.cities_presentation.ui.cities.CityItemView
import kotlinx.coroutines.flow.StateFlow

@Composable
fun CitiesScreen(
	citiesState: StateFlow<CitiesState>,
	navigateToCitiDetails: (cityId: Int) -> Unit = {}
) {
	val state by citiesState.collectAsStateWithLifecycle()

	CitiesScreenContent(
		citiesState = state,
		onClickAction = { navigateToCitiDetails.invoke(it.id) },
		modifier = Modifier
			.fillMaxSize()
			.padding(horizontal = HorizontalMediumPadding, vertical = VerticalSmallPadding)
	)
}

@Composable
fun CitiesScreenContent(
	modifier: Modifier = Modifier,
	onClickAction: (CityModel) -> Unit,
	citiesState: CitiesState
) {
	Surface(
		color = MaterialTheme.colors.background
	) {
		LazyColumn(modifier = modifier) {
			items(citiesState.citiesList) {model ->
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