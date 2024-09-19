package com.mk.ielts_speaking_practice.ui.presentation.cueCardScreens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mk.ielts_speaking_practice.domain.model.CueCardModel
import com.mk.ielts_speaking_practice.ui.presentation.LogoAnimation
import kotlinx.coroutines.delay

@Composable
fun CueCardScreen(type: CueCardType, cueCardModel: CueCardModel?) {
    val (isAnimationStarted, setAnimationStarted) = remember { mutableStateOf(false) }
    val (isShowCard, setIsShowCard) = remember { mutableStateOf(false) }
    val current = LocalConfiguration.current
    val width = current.screenWidthDp.dp
    val height = current.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = height * 0.05f)
        ) {
            Box(
                modifier = Modifier
                    .width(width * 0.3f)
                    .padding(horizontal = width * 0.02f)
                    .padding(vertical = height * 0.02f)
                    .background(Color(0xff2E2E2E), shape = RoundedCornerShape(50)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "II Part", color = Color.White, fontSize = 24.sp)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.height(20.dp))

        LaunchedEffect(Unit) {
            delay(1000)
            setAnimationStarted(true)
            delay(1500)
            setIsShowCard(true)
        }

        Box(contentAlignment = Alignment.Center) {
            if (isShowCard) {
                Box(modifier = Modifier.zIndex(1f)) {
                    if (type == CueCardType.RandomCueCard) TaskOfRandomCard(
                        width = width,
                        height = height,
                        modifier = Modifier
                            .zIndex(1f)
                            .offset(y = height * -2f),
                        cueCardModel!!
                    ) else if (type == CueCardType.CustomCueCard) InputsOfCustomCard(
                        width = width,
                        height = height,
                    )
                }
            }
            Box(modifier = Modifier.zIndex(0f)) {
                LogoAnimation(isAnimationStarted)
            }
        }
    }
}

@Composable
fun TaskOfRandomCard(
    width: Dp, height: Dp, modifier: Modifier = Modifier, cueCardModel: CueCardModel
) {
    Box(
        modifier = modifier
            .width(width * 0.9f)
            .height(height * 0.35f)
            .background(
                color = Color(0xff2E2E2E), shape = RoundedCornerShape(10)
            ), contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(width * 0.05f)
        ) {
            Text(
                text = cueCardModel.title,
                fontWeight = FontWeight.W500
            )
            Text(
                text = "You may say:\n" + "* ${cueCardModel.items[0]}\n" + "* ${cueCardModel.items[1]}\n" + "* ${cueCardModel.items[2]}.",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = cueCardModel.ending,
                fontWeight = FontWeight.Normal
            )

        }
    }
}

@Composable
fun InputsOfCustomCard(width: Dp, height: Dp, modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf(TextFieldValue()) }
    var firstItem by remember { mutableStateOf(TextFieldValue()) }
    var secondItem by remember { mutableStateOf(TextFieldValue()) }
    var thirdItem by remember { mutableStateOf(TextFieldValue()) }
    var ending by remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = modifier
            .width(width * 0.9f)
            .height(height * 0.55f)
            .offset(y = height * -0.1f)
            .background(
                color = Color(0xff2E2E2E), shape = RoundedCornerShape(10)
            ), contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(width * 0.05f)
        ) {
            TextFieldValues(value = title, onValueChanges = { title = it }, "Topic")
            TextFieldValues(value = firstItem, onValueChanges = { firstItem = it }, "First point")
            TextFieldValues(
                value = secondItem, onValueChanges = { secondItem = it }, "Second point"
            )
            TextFieldValues(value = thirdItem, onValueChanges = { thirdItem = it }, "Third point")
            TextFieldValues(value = ending, onValueChanges = { ending = it }, "Ending of cue card")
            Spacer(modifier = Modifier.height(height * 0.05f))
            Button(
                onClick = {
                    val cueCard = CueCardModel(
                        title = title.text,
                        items = listOf(firstItem.text, secondItem.text, thirdItem.text),
                        ending = ending.text
                    )
                    Log.d("TAG", "InputsOfCustomCard: $cueCard")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .background(
                        color = Color.LightGray, shape = RoundedCornerShape(20)
                    )
                    .padding(),
            ) {
                Text(text = "Submit and run")
            }
        }
    }
}

@Composable
fun TextFieldValues(
    value: TextFieldValue,
    onValueChanges: (TextFieldValue) -> Unit,
    header: String,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = value,
        maxLines = 1,
        label = { Text(text = header) },
        onValueChange = {
            onValueChanges(it)
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
    )
}