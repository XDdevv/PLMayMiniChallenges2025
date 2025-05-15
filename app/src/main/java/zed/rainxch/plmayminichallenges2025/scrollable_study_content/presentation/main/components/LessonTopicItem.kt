package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.R
import zed.rainxch.plmayminichallenges2025.core.ui.theme.LessonTopicStudyTheme
import zed.rainxch.plmayminichallenges2025.core.ui.theme.poltawskiFont
import zed.rainxch.plmayminichallenges2025.core.ui.theme.toColor
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.domain.model.LessonTopic

@Composable
fun LessonTopicItem(
    lessonTopic: LessonTopic,
    onItemClicked: () -> Unit,
    onPinClicked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val iconRes = if (lessonTopic.isPinned) R.drawable.state_pinned else R.drawable.ic_unpinned
    val borderWidth = if(lessonTopic.isPinned) 2.dp else 0.dp
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(borderWidth, LessonTopicStudyTheme.PRIMARY.toColor(), RoundedCornerShape(12.dp))
            .clickable { onItemClicked() }
            .background(Color.White)
            .padding(8.dp)
            ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = lessonTopic.title,
            color = LessonTopicStudyTheme.PRIMARY_TEXT.toColor(),
            fontFamily = poltawskiFont,
            fontSize = 22.sp,
            maxLines = 1,
            modifier = Modifier.weight(1f)
        )

        IconButton(
            onClick = {
                onPinClicked(!lessonTopic.isPinned)
            }
        ) {
            Image(
                painter = painterResource(iconRes),
                contentDescription = "Item pin state"
            )
        }
    }
}