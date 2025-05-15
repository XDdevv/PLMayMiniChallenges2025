package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.R
import zed.rainxch.plmayminichallenges2025.lesson_overview.domain.model.Category
import zed.rainxch.plmayminichallenges2025.core.ui.theme.LessonOverviewColors
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratSemiBoldFont

@Composable
fun CategoryItem(
    content: String,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .wrapContentWidth()
            .padding(bottom = 18.dp, end = 8.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = content,
            fontSize = 16.sp,
            color = textColor,
            fontFamily = montserratSemiBoldFont
        )
    }

}
