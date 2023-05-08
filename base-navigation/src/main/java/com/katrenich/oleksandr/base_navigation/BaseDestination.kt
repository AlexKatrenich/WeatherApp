package com.katrenich.oleksandr.base_navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

abstract class BaseDestination {
	abstract val route: String
	open val arguments: List<NamedNavArgument> = emptyList()
	open val deepLinks: List<NavDeepLink> = emptyList()
}