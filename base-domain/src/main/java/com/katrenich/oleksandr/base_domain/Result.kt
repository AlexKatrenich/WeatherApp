package com.katrenich.oleksandr.base_domain

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {

  data class Success<out T>(val data: T) : Result<T>()
  data class Error(val exception: Exception) : Result<Nothing>()
  object Loading : Result<Nothing>()

  override fun toString(): String {
    return when (this) {
      is Success<*> -> "Success[data=$data]"
      is Error -> "Error[exception=$exception]"
      Loading -> "Loading"
    }
  }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.isSuccess
  get() = this is Result.Success && data != null

val Result<*>.isFailure
  get() = !isSuccess

fun <T> Result<T>.successOr(fallback: T): T {
  return (this as? Result.Success<T>)?.data ?: fallback
}

suspend fun <T> Result<T>.onError(fallback: suspend (Exception) -> Unit = {}): Result<T> {
  if (this is Result.Error) {
    fallback.invoke(this.exception)
  }
  return this
}

suspend fun <T> Result<T>.onSuccess(fallback: suspend (T) -> Unit = {}): Result<T> {
  if (this is Result.Success) {
    fallback.invoke(this.data)
  }
  return this
}

val <T> Result<T>.data: T?
  get() = (this as? Result.Success)?.data

val <T> Result<T>.error: Exception
  get() = (this as Result.Error).exception

val <T> Result<T>.onError: Exception
  get() = (this as Result.Error).exception