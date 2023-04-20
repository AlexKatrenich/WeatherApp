package com.katrenich.oleksandr.base_domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 * Executes business logic in its execute method and keep posting updates to the result as
 * [Result<R>].
 * Handling an exception (emit [Result.failure] to the result) is the subclasses's responsibility.
 */
abstract class FlowUseCaseWithoutParams<R>(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
  operator fun invoke(): Flow<Result<R>> = execute()
    .catch { e -> emit(Result.Error(Exception(e))) }
    .flowOn(dispatcher)

  protected abstract fun execute(): Flow<Result<R>>
}
