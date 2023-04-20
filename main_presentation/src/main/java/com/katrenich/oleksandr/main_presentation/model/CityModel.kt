package com.katrenich.oleksandr.main_presentation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.katrenich.oleksandr.base_presentation.R

data class CityModel(
	val id: Int,
	@StringRes val nameRes: Int,
	@DrawableRes val imageRes: Int
)

data class CitiesModel(
	val cities: List<CityModel> = emptyList()
)

private fun getCityNamesAndImagesList() = listOf(
	R.string.city_name_cherkasy to R.drawable.cherkasy,
	R.string.city_name_chernihiv to R.drawable.chernihiv,
	R.string.city_name_chernivtsi to R.drawable.chernivtsi,
	R.string.city_name_dnipro to R.drawable.dnipro,
	R.string.city_name_donetsk to R.drawable.donetsk,
	R.string.city_name_ivano_frankivsk to R.drawable.ivano_frankivsk,
	R.string.city_name_kharkiv to R.drawable.kharkiv,
	R.string.city_name_kherson to R.drawable.kherson,
	R.string.city_name_khmelnitsky to R.drawable.khmelnitsky,
	R.string.city_name_kropyvnitskyi to R.drawable.kropyvnitskyi,
	R.string.city_name_kyiv to R.drawable.kyiv,
	R.string.city_name_luhansk to R.drawable.luhansk,
	R.string.city_name_lutsk to R.drawable.lutsk,
	R.string.city_name_lviv to R.drawable.lviv,
	R.string.city_name_mykolaiv to R.drawable.mykolaiv,
	R.string.city_name_odesa to R.drawable.odesa,
	R.string.city_name_poltava to R.drawable.poltava,
	R.string.city_name_rivne to R.drawable.rivne,
	R.string.city_name_simferopol to R.drawable.simferopol,
	R.string.city_name_sumy to R.drawable.sumy,
	R.string.city_name_ternopil to R.drawable.ternopil,
	R.string.city_name_uzhgorod to R.drawable.uzhgorod,
	R.string.city_name_vinnytsia to R.drawable.vinnytsia,
	R.string.city_name_zaporizhzhia to R.drawable.zaporizhzhia,
	R.string.city_name_zhitomir to R.drawable.zhitomir
)

fun getCityModelsList(): List<CityModel> {
	val namesAndImagesList = getCityNamesAndImagesList()

	return namesAndImagesList
		.mapIndexed { index, pair ->
			CityModel(
				id = index,
				nameRes = pair.first,
				imageRes = pair.second
			)
		}
}