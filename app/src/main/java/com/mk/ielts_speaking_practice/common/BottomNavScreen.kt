package com.mk.ielts_speaking_practice.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {
    data object Home : BottomNavScreen(
        route = "home",
        title = "Home",
        icon = Icons.Filled.Home
    )

    data object History : BottomNavScreen(
        route = "history",
        title = "History",
        icon = Icons.Filled.History
    )
}