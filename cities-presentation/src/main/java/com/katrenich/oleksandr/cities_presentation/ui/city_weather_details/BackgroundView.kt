package com.katrenich.oleksandr.cities_presentation.ui.city_weather_details

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import com.katrenich.oleksandr.base_presentation.ui.theme.DetailsScreenImageHeight

@Composable
internal fun BackgroundView(
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