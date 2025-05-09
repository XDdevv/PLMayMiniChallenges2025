package zed.rainxch.plmayminichallenges2025.lesson_overview.presentation.components

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
import zed.rainxch.plmayminichallenges2025.ui.theme.LessonOverviewColors
import zed.rainxch.plmayminichallenges2025.ui.theme.montserratSemiBoldFont

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier
) {
    when (category) {
        is Category.Filled -> {
            Row(
                modifier = modifier
                    .wrapContentWidth()
                    .padding(bottom = 18.dp, end = 8.dp)
                    .clip(CircleShape)
                    .background(category.backgroundColor)
                    .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (category.hasIcon) {
                    Icon(
                        painter = painterResource(category.iconRes),
                        contentDescription = "Icon",
                        tint = category.textColor
                    )

                    Spacer(Modifier.width(8.dp))
                }
                Text(
                    text = category.content,
                    fontSize = 16.sp,
                    color = category.textColor,
                    fontFamily = montserratSemiBoldFont
                )
            }
        }

        is Category.Outlined -> {
            Row(
                modifier = modifier
                    .wrapContentWidth()
                    .padding(bottom = 18.dp, end = 8.dp)
                    .clip(CircleShape)
                    .border(1.dp, LessonOverviewColors.Stroke.color, CircleShape)
                    .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (category.hasIcon) {
                    Icon(
                        painter = painterResource(category.iconRes),
                        contentDescription = "Icon",
                        tint = LessonOverviewColors.BackgroundPurplePillTextIconColor.color
                    )

                    Spacer(Modifier.width(8.dp))
                }
                Text(
                    text = category.content,
                    fontSize = 16.sp,
                    color = LessonOverviewColors.SecondaryText.color,
                    fontFamily = montserratSemiBoldFont
                )
            }
        }
    }
}

@Preview
@Composable
private fun CategoryItemPreview() {
    CategoryItem(
        category = Category.Outlined(true, R.drawable.ic_time, "15 mins")
    )
}

@Preview
@Composable
private fun CategoryItem2Preview() {
    CategoryItem(
        category = Category.Filled(
            backgroundColor = Color(0xffEFEFFC),
            textColor = Color(0xff6B74F8),
            hasIcon = true,
            iconRes = R.drawable.ic_intermidate,
            content = "Intermediate"
        )
    )
}