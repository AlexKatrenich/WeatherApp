package com.katrenich.oleksandr.main_presentation.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.compose.setContent
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
import com.katrenich.oleksandr.base_presentation.ui.screen.BaseActivity
import com.katrenich.oleksandr.base_presentation.ui.theme.SimpleWeatherAppTheme
import com.katrenich.oleksandr.main_presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DetailsScreen()
		}
	}
}

@Composable
fun DetailsScreen() {
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Background(
			backgroundImage = painterResource(id = R.drawable.london),
			backgroundColor = MaterialTheme.colors.background,
			modifier = Modifier.fillMaxSize()
		)
		Text(
			text = "London",
			color = if (isSystemInDarkTheme()) Color.White else Color.Black
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
				.height(500.dp)
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

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
	SimpleWeatherAppTheme {
		DetailsScreen()
	}
}