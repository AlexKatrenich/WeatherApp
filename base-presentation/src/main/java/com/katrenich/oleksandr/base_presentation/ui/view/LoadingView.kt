package com.katrenich.oleksandr.base_presentation.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.katrenich.oleksandr.base_presentation.ui.theme.ProgressBarSize
import com.katrenich.oleksandr.base_presentation.ui.theme.SimpleWeatherAppTheme

@Composable
fun LoadingView(
	modifier: Modifier
) {
	Box(
		modifier = modifier
			.background(
				color = Color.Gray.copy(alpha = 0.4f)
			),
		contentAlignment = Alignment.Center
	) {
		CircularProgressIndicator(color = Color.Green, modifier = Modifier.size(ProgressBarSize))
	}
}

@Preview
@Composable
fun LoadingViewPreview() {
	SimpleWeatherAppTheme {
		LoadingView(modifier = Modifier.fillMaxSize())
	}
}