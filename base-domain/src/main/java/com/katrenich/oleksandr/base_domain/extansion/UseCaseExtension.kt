package com.katrenich.oleksandr.base_domain.extansion

import com.katrenich.oleksandr.base_domain.UseCase
import com.katrenich.oleksandr.base_domain.UseCaseWithoutParams
import com.katrenich.oleksandr.base_domain.error
import com.katrenich.oleksandr.base_domain.Result

suspend fun <P, T> UseCase<P, T>.launch(params: P, onError: (Throwable) -> Unit): T? {
  val result = invoke(params)
  return if (result is Result.Success) {
    result.data
  } else {
    onError(result.error)
    null
  }
}

suspend fun <T> UseCaseWithoutParams<T>.launch(onError: (Throwable) -> Unit): T? {
  val result = invoke()
  return if (result is Result.Success) {
    result.data
  } else {
    onError(result.error)
    null
  }
}