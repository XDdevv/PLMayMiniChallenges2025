package zed.rainxch.plmayminichallenges2025.lesson_overview.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.core.ui.theme.LessonOverviewColors
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratLightFont

@Composable
fun GonnaLearnItem(
    item: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Arrow forward",
            tint = LessonOverviewColors.BackgroundPurplePillTextIconColor.color,
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text = item,
            fontSize = 18.sp,
            fontFamily = montserratLightFont,
            color = LessonOverviewColors.PrimaryText.color
        )
    }
}