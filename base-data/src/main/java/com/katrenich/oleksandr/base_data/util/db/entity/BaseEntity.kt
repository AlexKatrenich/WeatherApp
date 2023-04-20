package com.katrenich.oleksandr.base_data.util.db.entity

abstract class BaseEntity<D> {
  abstract fun toDomain(): D
}

fun <E : BaseEntity<D>, D> List<E>.toDomain(): List<D> {
  return this.map { entity -> entity.toDomain() }
}
