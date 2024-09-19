package com.mk.ielts_speaking_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.mk.ielts_speaking_practice.ui.presentation.MainScreen
import com.mk.ielts_speaking_practice.ui.theme.Ielts_speaking_practiceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ielts_speaking_practiceTheme {
                MainScreen()
            }
        }
    }
}
