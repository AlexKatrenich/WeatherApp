package com.katrenich.oleksandr.base_data.util

import android.util.Log
import com.katrenich.oleksandr.base_data.BuildConfig

fun log(message: String) {
  logd(message)
}

fun logd(obj: Any?, message: String? = null) {
  if (!BuildConfig.DEBUG) return
  obj?.let {
    Log.d(it.toString(), message ?: "")
  } ?: run {
    logd(message ?: "")
  }
}

fun logd(message: String) {
  if (!BuildConfig.DEBUG) return
  Log.d("Katrenich", message)
}