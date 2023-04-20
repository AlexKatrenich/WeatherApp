package com.katrenich.oleksandr.main_presentation.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.katrenich.oleksandr.base_presentation.ui.theme.DetailsScreenImageHeight
import com.katrenich.oleksandr.base_presentation.ui.theme.DetailScreenContentHeight
import com.katrenich.oleksandr.base_presentation.ui.theme.SimpleWeatherAppTheme
import com.katrenich.oleksandr.base_presentation.R

@Composable
fun DetailsScreen(
	imageRes: Int = R.drawable.kyiv
) {
	// set status bar hidden
	val systemUiController: SystemUiController = rememberSystemUiController()
	systemUiController.isStatusBarVisible = false

	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.BottomCenter
	) {
		Background(
			backgroundImage = painterResource(id = imageRes),
			backgroundColor = MaterialTheme.colors.background,
			modifier = Modifier.fillMaxSize()
		)
		DetailsWeatherView(
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
	modifier: Modifier
) {
	Column(
		modifier = modifier
	) {
		Text(
			text = "Kyiv",
			color = if (isSystemInDarkTheme()) Color.White else Color.Black,
			style = MaterialTheme.typography.h1,
			modifier = Modifier.padding(start = 38.dp, top = 24.dp)
		)
	}
}

@Preview(name = "Default preview")
@Composable
fun DetailsScreenPreview() {
	SimpleWeatherAppTheme {
		DetailsScreen()
	}
}