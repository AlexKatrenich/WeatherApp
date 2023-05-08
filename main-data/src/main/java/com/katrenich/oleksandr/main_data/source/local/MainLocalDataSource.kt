package com.katrenich.oleksandr.main_data.source.local

import com.katrenich.oleksandr.main_data.source.contract.MainDataSource
import com.katrenich.oleksandr.main_data.source.local.cache.MainCache
import javax.inject.Inject

class MainLocalDataSource @Inject constructor(
	private val cache: MainCache
) : MainDataSource.Local {


}