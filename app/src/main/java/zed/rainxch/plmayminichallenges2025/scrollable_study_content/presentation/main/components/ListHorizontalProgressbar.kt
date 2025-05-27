package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
import zed.rainxch.plmayminichallenges2025.core.ui.theme.LessonTopicStudyTheme
import zed.rainxch.plmayminichallenges2025.core.ui.theme.toColor

@Composable
fun ListHorizontalProgressbar(modifier: Modifier = Modifier, scrollState: LazyListState) {
    val totalItems = scrollState.layoutInfo.totalItemsCount
    val visibleItems = scrollState.layoutInfo.visibleItemsInfo.size
    val firstVisibleItem = scrollState.firstVisibleItemIndex

    if (totalItems > visibleItems && visibleItems > 0) {
        val offset = firstVisibleItem.toFloat() / totalItems

        Box(
            modifier = modifier
                .height(2.dp)
                .fillMaxWidth()
                .drawBehind {
                    val scrollbarWidth = size.width * offset

                    drawRoundRect(
                        color = LessonTopicStudyTheme.PRIMARY.toColor(),
                        topLeft = Offset(x = 0f, y = 0f),
                        size = Size(width = scrollbarWidth, height = size.height),
                        cornerRadius = CornerRadius(2.dp.toPx())
                    )
                }
        )
    }
}