package com.mk.ielts_speaking_practice.ui.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mk.ielts_speaking_practice.common.BottomNavScreen
import com.mk.ielts_speaking_practice.ui.presentation.history.HistoryScreen
import com.mk.ielts_speaking_practice.ui.presentation.home.HomeScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavScreen.Home.route) {
        composable(route = BottomNavScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavScreen.History.route) {
            HistoryScreen()
        }
    }
}