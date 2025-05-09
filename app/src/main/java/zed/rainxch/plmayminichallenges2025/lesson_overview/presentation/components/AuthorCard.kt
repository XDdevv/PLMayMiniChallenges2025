package zed.rainxch.plmayminichallenges2025.lesson_overview.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.R
import zed.rainxch.plmayminichallenges2025.lesson_overview.domain.model.Author
import zed.rainxch.plmayminichallenges2025.ui.theme.LessonOverviewColors
import zed.rainxch.plmayminichallenges2025.ui.theme.montserratSemiBoldFont

@Composable
fun AuthorCard(
    author: Author,
    modifier: Modifier = Modifier
) {
    val authorPictureBackground = Brush.linearGradient(
        listOf(
            Color(0xff6B74F8),
            Color(0xffFDE5F3)
        )
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(100f))
            .background(LessonOverviewColors.TeacherPillBG.color)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(author.profilePicId),
            contentDescription = "Author's picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(authorPictureBackground)
                .padding(2.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.width(10.dp))

        Text(
            text = author.fullName,
            fontFamily = montserratSemiBoldFont,
            color = LessonOverviewColors.PrimaryText.color,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
private fun AuthorCardPreview() {
    AuthorCard(
        author = Author("Dr. Eleanor Maxwell", R.drawable.author)
    )
}