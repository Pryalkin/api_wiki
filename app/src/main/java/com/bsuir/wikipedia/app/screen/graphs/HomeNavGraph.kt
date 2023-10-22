package com.bsuir.wikipedia.app.screen.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bsuir.wikipedia.Singletons
import com.bsuir.wikipedia.app.screen.screens.*

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Screen.Home.route,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable (route = BottomBarScreen.Home.route) {
            WikiContent()
        }
        composable(route = BottomBarScreen.Profile.route) {
            HomeContext(navController = navController)
        }
        composable(
            route = Screen.DetailId.route,
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                })
        ){
            val viewModel = Singletons.appViewModel
            val obj2 = viewModel.obj2.observeAsState()
            LaunchedEffect(Unit) {
                val url = it.arguments?.getString("title").toString()
                val newUrl = url.replace('_', '/')
                viewModel.getItem(newUrl)
            }
            obj2.value?.query?.pages?.get(it.arguments?.getString("id").toString())?.let{ it1 ->
                DetailScreen(num = it1)
            }
        }
    }
}

