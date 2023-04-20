package com.katrenich.oleksandr.base_domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Executes business logic synchronously or asynchronously using Coroutines.
 */
abstract class UseCaseWithoutParams<R>(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {

  /** Executes the use case asynchronously and returns a [Result].
   *
   * @return a [Result].
   *
   * @param parameters the input parameters to run the use case with
   */
  suspend operator fun invoke(): Result<R> {
    return try {
      // Moving all use case's executions to the injected dispatcher
      // In production code, this is usually the Default dispatcher (background thread)
      // In tests, this becomes a TestCoroutineDispatcher
      withContext(dispatcher) {
        execute().let {
          Result.Success(it)
        }
      }
    } catch (e: Exception) {
      Result.Error(e)
    }
  }

  /**
   * Override this to set the code to be executed.
   */
  @Throws(RuntimeException::class)
  protected abstract suspend fun execute(): R
}
