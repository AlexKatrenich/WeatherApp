package com.katrenich.oleksandr.base_presentation.extension

import android.app.Activity
import android.os.Build
import android.view.WindowManager

fun Activity.hideStatusBarCompat() {
	with(window) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
			decorView.windowInsetsController?.hide(
				android.view.WindowInsets.Type.statusBars()
			)
		} else {
			clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
			addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
		}
	}
}

fun Activity.showStatusBarCompat() {
	with(window) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
			decorView.windowInsetsController?.show(
				android.view.WindowInsets.Type.statusBars()
			)
		} else {
			with(window) {
				clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
				addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
			}
		}
	}
}