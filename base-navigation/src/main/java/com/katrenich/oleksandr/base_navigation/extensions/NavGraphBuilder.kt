package com.katrenich.oleksandr.base_navigation.extensions

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.katrenich.oleksandr.base_navigation.BaseDestination

fun NavGraphBuilder.navigationTo(
	destination: BaseDestination,
	content: @Composable (NavBackStackEntry) -> Unit
) {
	composable(
		route = destination.route,
		arguments = destination.arguments,
		deepLinks = destination.deepLinks,
		content = content
	)
}