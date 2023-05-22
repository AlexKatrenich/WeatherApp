package com.katrenich.oleksandr.cities_presentation.ui.cities

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.katrenich.oleksandr.base_presentation.R
import com.katrenich.oleksandr.base_presentation.ui.theme.*
import com.katrenich.oleksandr.cities_domain.model.CityModel

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
				modifier = Modifier.padding(start = HorizontalMediumPadding)
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
				R.string.city_name_kharkiv,
				R.drawable.kharkiv
			),
			onClickAction = {},
			modifier = Modifier
				.fillMaxWidth()
				.height(CityItemViewHeight)
		)
	}
}