package com.mk.ielts_speaking_practice.ui.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOutExpo
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import com.mk.ielts_speaking_practice.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun LogoAnimation(isAnimationStarted: Boolean) {
    var scaleState by remember { mutableFloatStateOf(3f) }
    val endScaleState by remember { mutableFloatStateOf(1f) }
    val scope = rememberCoroutineScope()
    var currentRotation by remember { mutableFloatStateOf(10f) }

    val rotation = remember { Animatable(currentRotation) }
    val scaleAnimation = animateFloatAsState(
        targetValue = scaleState, animationSpec = tween(durationMillis = 400), label = ""
    )
    val offsetX = remember { Animatable(0f) }
    val offsetY = remember { Animatable(0f) }

    val endScaleAnimation = animateFloatAsState(
        targetValue = endScaleState, animationSpec = tween(durationMillis = 400), label = ""
    )

    LaunchedEffect(isAnimationStarted) {
        scope.launch {
            scaleState = 1f
            delay(600)
            if (isAnimationStarted) {
                rotation.animateTo(
                    targetValue = currentRotation + 70,
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = EaseInOutExpo
                    )
                ) {
                    currentRotation = value
                }
                launch {
                    offsetX.animateTo(
                        targetValue = 400f,
                        animationSpec = tween(durationMillis = 500)
                    )
                }
                launch {
                    offsetY.animateTo(
                        targetValue = 400f,
                        animationSpec = tween(durationMillis = 500)
                    )
                }
                scaleState = 3.0f
            }
            delay(1500)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .scale(scaleAnimation.value * endScaleAnimation.value)
                .rotate(currentRotation)
                .offset { IntOffset(offsetX.value.roundToInt(), offsetY.value.roundToInt()) },

            contentScale = ContentScale.Crop
        )
    }
}