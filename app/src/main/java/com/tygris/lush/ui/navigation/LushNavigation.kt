package com.tygris.lush.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tygris.lush.ui.screens.mainScreen.MainScreenScaffold
import com.tygris.lush.ui.state.TrackListViewModel

//App navigation...using jetpack compose navigation..........
@Composable
fun AppNavigation(viewModel: TrackListViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinations.Home.route){
        composable(route = Destinations.Home.route){
            MainScreenScaffold(viewModel)
        }
    }

}

sealed class Destinations(val route: String){
    object Home : Destinations(route="HomeScreen")
}