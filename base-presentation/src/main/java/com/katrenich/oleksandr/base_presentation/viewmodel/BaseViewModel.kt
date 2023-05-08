package com.katrenich.oleksandr.base_presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {

	open val jobs = mutableListOf<Job>()

	internal fun cancelJobs() {
		jobs.forEach { it.cancel() }
	}

	override fun onCleared() {
		cancelJobs()
		super.onCleared()
	}
}