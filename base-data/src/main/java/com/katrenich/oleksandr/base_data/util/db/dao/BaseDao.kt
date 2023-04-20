package com.katrenich.oleksandr.base_data.util.db.dao

import androidx.room.*

@Dao
abstract class BaseDao<T> {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  abstract suspend fun insert(entity: T): Long

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  abstract suspend fun insert(entities: List<T>): List<Long>

  @Update
  abstract suspend fun update(entity: T): Int

  @Update
  abstract suspend fun update(entities: List<T>): Int

  @Delete
  abstract suspend fun delete(entity: T)

  @Delete
  abstract suspend fun delete(entities: List<T>)

  @Transaction
  open suspend fun insertOrUpdate(entity: T) {
    val id = insert(entity)
    if (id == -1L) update(entity)
  }

  @Transaction
  open suspend fun insertOrUpdate(entities: List<T>) {
    val insertResult = insert(entities)
    val updateList = mutableListOf<T>()

    for (entity in insertResult.indices) {
      if (insertResult[entity] == -1L) updateList.add(entities[entity])
    }

    if (updateList.isNotEmpty()) update(updateList)
  }
}
