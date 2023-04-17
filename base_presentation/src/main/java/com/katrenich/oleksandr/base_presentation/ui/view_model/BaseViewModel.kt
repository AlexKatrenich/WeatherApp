package com.katrenich.oleksandr.base_presentation.ui.view_model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {

	open val jobs = mutableListOf<Job>()

	fun cancelJobs() {
		jobs.forEach { it.cancel() }
	}
}