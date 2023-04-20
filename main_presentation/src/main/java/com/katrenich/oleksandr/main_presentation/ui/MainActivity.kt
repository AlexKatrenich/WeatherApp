package com.katrenich.oleksandr.main_presentation.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import com.katrenich.oleksandr.base_presentation.ui.screen.BaseActivity
import com.katrenich.oleksandr.base_presentation.ui.theme.SimpleWeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			SimpleWeatherAppTheme {
				CitiesScreen()
			}
		}
	}
}