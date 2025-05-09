package zed.rainxch.plmayminichallenges2025.daily_word_challenge.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.R
import zed.rainxch.plmayminichallenges2025.daily_word_challenge.data.wordList
import zed.rainxch.plmayminichallenges2025.ui.theme.montserratLightFont
import zed.rainxch.plmayminichallenges2025.ui.theme.poltawskiFont

@Composable
fun DailyWordChallenge(
    onSpeakClicked : (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val word by remember { mutableStateOf(wordList.random()) }

    val backgroundColor = Brush.linearGradient(
        listOf(
            Color(0xff6B74F8),
            Color(0xffFDE5F3),
            Color(0xffFEF7EE)
        ),
    )
    val wordTextColor = Color(0xff13182C)
    val definitionTextColor = Color(0xff4C4F59)
    val voiceIconColor = Color(0xff6B74F8)

    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .size(364.dp)
                    .padding(24.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(32.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = word.word,
                    fontFamily = poltawskiFont,
                    fontSize = 38.sp,
                    textAlign = TextAlign.Center,
                    color = wordTextColor,
                    maxLines = 1
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = word.definition,
                    fontFamily = montserratLightFont,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = definitionTextColor
                )
            }

            IconButton(
                onClick = {
                    onSpeakClicked("Word : ${word.word}, Definition: ${word.definition}")
                },
                modifier = Modifier.size(80.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = voiceIconColor
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_voice),
                    contentDescription = "Voice icon",
                    modifier = Modifier.padding(12.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun DailyWordChallengePreview() {
//    DailyWordChallenge()
}