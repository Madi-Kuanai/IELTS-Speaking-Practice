package com.mk.ielts_speaking_practice.ui.presentation.composables

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DotProperties
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.HorizontalIndicatorProperties
import ir.ehsannarmani.compose_charts.models.IndicatorPosition
import ir.ehsannarmani.compose_charts.models.Line

@Composable
fun LineBarChart() {
    LineChart(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp),
        data = listOf(
            Line(
                values = listOf(8.0, 5.5, 6.0, 5.5, 7.0, 6.0, 5.5, 7.0),
                color = SolidColor(Color(0xFF23af92)),
                firstGradientFillColor = Color(0xFF2BC0A1).copy(alpha = .5f),
                secondGradientFillColor = Color.Transparent,
                strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                gradientAnimationDelay = 800,
                drawStyle = DrawStyle.Stroke(width = 2.dp),
                curvedEdges = true,
                dotProperties = DotProperties(
                    enabled = true,
                    color = SolidColor(Color.White),
                    strokeWidth = 2.dp,
                    radius = 4.dp,
                    strokeColor = SolidColor(
                        Color(0xFF2BC0A1),
                    ),

                    ),
                label = "Progress"
            )
        ),
        minValue = 4.0, maxValue = 9.0,
        animationMode = AnimationMode.Together(delayBuilder = {
            it * 500L
        }),
        indicatorProperties = HorizontalIndicatorProperties(
            enabled = true,
            textStyle = MaterialTheme.typography.labelSmall.copy(Color.White),
            count = 5,
            position = IndicatorPosition.Horizontal.End,
            padding = 32.dp,
            contentBuilder = { indicator ->
                "%.2f".format(indicator)
            },
        ),
    )
}