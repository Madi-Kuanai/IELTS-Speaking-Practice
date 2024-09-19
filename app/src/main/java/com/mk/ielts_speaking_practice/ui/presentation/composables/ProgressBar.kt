package com.mk.ielts_speaking_practice.ui.presentation.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun ProgressBarCard() {
    val current = LocalConfiguration.current
    val height = current.screenHeightDp
    val width = current.screenWidthDp

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xff1D191A),
        ),
        modifier = Modifier
            .size(width = (0.95f * width).dp, height = height.dp * 0.35f)
    ) {
        LineBarChart()
    }
}