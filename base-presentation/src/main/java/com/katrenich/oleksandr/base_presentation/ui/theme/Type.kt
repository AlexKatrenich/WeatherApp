package com.katrenich.oleksandr.base_presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.katrenich.oleksandr.base_presentation.R

// Set of Material typography styles to start with
val monseratRegular = FontFamily(Font(R.font.montserrat_regular))
val monseratLight = FontFamily(Font(R.font.montserrat_light))
val monseratMedium = FontFamily(Font(R.font.montserrat_medium))

val Typography = Typography(
	defaultFontFamily = monseratRegular,
	body1 = TextStyle(
		fontFamily = monseratRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 12.sp
	),
	h1 = TextStyle(
		fontFamily = monseratMedium,
		fontWeight = FontWeight.Normal,
		fontSize = 48.sp
	),
	h2 = TextStyle(
		fontFamily = monseratLight,
		fontWeight = FontWeight.Normal,
		fontSize = 36.sp
	),
	h3 = TextStyle(
		fontFamily = monseratLight,
		fontWeight = FontWeight.Normal,
		fontSize = 24.sp
	),
	caption = TextStyle(
		fontFamily = monseratLight,
		fontWeight = FontWeight.Normal,
		fontSize = 18.sp
	)
)