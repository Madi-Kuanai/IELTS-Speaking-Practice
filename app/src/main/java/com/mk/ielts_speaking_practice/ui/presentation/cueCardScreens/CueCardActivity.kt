package com.mk.ielts_speaking_practice.ui.presentation.cueCardScreens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mk.ielts_speaking_practice.domain.model.CueCardModel
import com.mk.ielts_speaking_practice.ui.theme.Ielts_speaking_practiceTheme
import kotlinx.coroutines.launch

class CueCardActivity : ComponentActivity() {
    private val viewModel = ViewModelProvider(this)[CueCardActivityViewModel::class.java]
    private lateinit var cueCard: CueCardModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = intent.getStringExtra("type")
        setObservers()
        setContent {
            Ielts_speaking_practiceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    if (type == "Random") {
                        CueCardScreen(CueCardType.RandomCueCard, cueCard)
                    } else if (type == "Custom") {
                        CueCardScreen(CueCardType.CustomCueCard, cueCard)
                    }
                }
            }
        }
    }

    private fun setObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.cueCard.collect {
                    when (it) {
                        it!! -> {
                            cueCard = it
                            Log.e("TAG", "setObservers: $cueCard")
                        }
                    }
                }
            }
        }
    }
}
