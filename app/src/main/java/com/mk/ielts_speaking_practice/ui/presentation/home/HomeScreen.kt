package com.mk.ielts_speaking_practice.ui.presentation.home

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mk.ielts_speaking_practice.R
import com.mk.ielts_speaking_practice.ui.presentation.composables.PracticeCard
import com.mk.ielts_speaking_practice.ui.presentation.composables.ProgressBarCard
import com.mk.ielts_speaking_practice.ui.presentation.cueCardScreens.CueCardActivity
import com.mk.ielts_speaking_practice.ui.presentation.cueCardScreens.CueCardType


@Composable
fun HomeScreen() {
    val context = LocalContext.current;

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            Modifier.padding(all = LocalConfiguration.current.screenWidthDp.dp * 0.05f),
            Arrangement.SpaceEvenly,
            Alignment.CenterHorizontally
        ) {
            ProgressBarCard()
            Spacer(modifier = Modifier.height(height = 16.dp))
            PracticeCard(title = "Random topic",
                describe = "In this mode, you should answer to random cue card.",
                icon = painterResource(id = R.drawable.dice),
                onClick = {
                    val intent = Intent(context, CueCardActivity::class.java)
                    intent.putExtra("type", "Random")
                    context.startActivity(intent)
                })
            Spacer(modifier = Modifier.height(height = 16.dp))
            PracticeCard(title = "Your topic",
                describe = "In this mode, you can write your own cue card and answer to it",
                icon = painterResource(id = R.drawable.edit),
                onClick = {
                    val intent = Intent(context, CueCardActivity::class.java)
                    intent.putExtra("type", "Custom")
                    context.startActivity(intent)
                })
        }
    }
}
