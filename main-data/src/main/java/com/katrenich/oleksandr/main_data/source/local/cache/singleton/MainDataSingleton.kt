package com.katrenich.oleksandr.main_data.source.local.cache.singleton

import com.katrenich.oleksandr.base_presentation.R
import com.katrenich.oleksandr.main_data.source.local.cache.model.CityLocalModel

object MainDataSingleton {

	fun getCitiesList() =
		listOf(
			CityLocalModel(
				id = 1,
				nameRes = R.string.city_name_cherkasy,
				imageRes = R.drawable.cherkasy,
				location = "49.446,32.058"
			),
			CityLocalModel(
				id = 2,
				nameRes = R.string.city_name_chernihiv,
				imageRes = R.drawable.chernihiv,
				location = "51.498,31.288"
			),
			CityLocalModel(
				id = 3,
				nameRes = R.string.city_name_chernivtsi,
				imageRes = R.drawable.chernivtsi,
				location = "48.293,25.935"
			),
			CityLocalModel(
				id = 4,
				nameRes = R.string.city_name_dnipro,
				imageRes = R.drawable.dnipro,
				location = "48.466,35.038"
			),
			CityLocalModel(
				id = 5,
				nameRes = R.string.city_name_donetsk,
				imageRes = R.drawable.donetsk,
				location = "48.017,37.795"
			),
			CityLocalModel(
				id = 6,
				nameRes = R.string.city_name_ivano_frankivsk,
				imageRes = R.drawable.ivano_frankivsk,
				location = "48.921,24.715"
			),
			CityLocalModel(
				id = 7,
				nameRes = R.string.city_name_kharkiv,
				imageRes = R.drawable.kharkiv,
				location = "49.993,36.224"
			),
			CityLocalModel(
				id = 8,
				nameRes = R.string.city_name_kherson,
				imageRes = R.drawable.kherson,
				location = "46.635,32.615"
			),
			CityLocalModel(
				id = 9,
				nameRes = R.string.city_name_khmelnitsky,
				imageRes = R.drawable.khmelnitsky,
				location = "49.423,26.987"
			),
			CityLocalModel(
				id = 10,
				nameRes = R.string.city_name_kropyvnitskyi,
				imageRes = R.drawable.kropyvnitskyi,
				location = "48.509,32.258"
			),
			CityLocalModel(
				id = 11,
				nameRes = R.string.city_name_kyiv,
				imageRes = R.drawable.kyiv,
				location ="50.449,30.523"
			),
			CityLocalModel(
				id = 12,
				nameRes = R.string.city_name_luhansk,
				imageRes = R.drawable.luhansk,
				location ="48.573,39.303"
			),
			CityLocalModel(
				id = 13,
				nameRes = R.string.city_name_lutsk,
				imageRes = R.drawable.lutsk,
				location = "50.747,25.323"
			),
			CityLocalModel(
				id = 14,
				nameRes = R.string.city_name_lviv,
				imageRes = R.drawable.lviv,
				location = "49.840,24.0283"
			),
			CityLocalModel(
				id = 15,
				nameRes = R.string.city_name_mykolaiv,
				imageRes = R.drawable.mykolaiv,
				location = "46.974,32.005"
			),
			CityLocalModel(
				id = 16,
				nameRes = R.string.city_name_odesa,
				imageRes = R.drawable.odesa,
				location = "46.482,30.722"
			),
			CityLocalModel(
				id = 17,
				nameRes = R.string.city_name_poltava,
				imageRes = R.drawable.poltava,
				location = "49.588,34.541"
			),
			CityLocalModel(
				id = 18,
				nameRes = R.string.city_name_rivne,
				imageRes = R.drawable.rivne,
				location = "50.619,26.252"
			),
			CityLocalModel(
				id = 19,
				nameRes = R.string.city_name_simferopol,
				imageRes = R.drawable.simferopol,
				location = "44.952,34.098"
			),
			CityLocalModel(
				id = 20,
				nameRes = R.string.city_name_sumy,
				imageRes = R.drawable.sumy,
				location = "50.908,34.799"
			),
			CityLocalModel(
				id = 21,
				nameRes = R.string.city_name_ternopil,
				imageRes = R.drawable.ternopil,
				location = "49.554,25.592"
			),
			CityLocalModel(
				id = 22,
				nameRes = R.string.city_name_uzhgorod,
				imageRes = R.drawable.uzhgorod,
				location = "48.620,22.288"
			),
			CityLocalModel(
				id = 23,
				nameRes = R.string.city_name_vinnytsia,
				imageRes = R.drawable.vinnytsia,
				location = "49.232,28.470"
			),
			CityLocalModel(
				id = 24,
				nameRes = R.string.city_name_zaporizhzhia,
				imageRes = R.drawable.zaporizhzhia,
				location = "47.840,35.135"
			),
			CityLocalModel(
				id = 25,
				nameRes = R.string.city_name_zhitomir,
				imageRes = R.drawable.zhitomir,
				location = "50.255,28.660"
			)
		)
}