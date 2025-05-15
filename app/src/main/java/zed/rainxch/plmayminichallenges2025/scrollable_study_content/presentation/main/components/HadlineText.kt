package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.core.ui.theme.LessonTopicStudyTheme
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratSemiBoldFont
import zed.rainxch.plmayminichallenges2025.core.ui.theme.toColor

@Composable
fun HeadlineText(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(bottom = 8.dp)
    ) {
        Text(
            text = text.uppercase(),
            fontSize = 16.sp,
            fontFamily = montserratSemiBoldFont,
            color = LessonTopicStudyTheme.TERTIARY_TEXT.toColor()
        )
    }
}