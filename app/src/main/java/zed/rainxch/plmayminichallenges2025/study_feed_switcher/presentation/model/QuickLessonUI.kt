package zed.rainxch.plmayminichallenges2025.study_feed_switcher.presentation.model

import androidx.compose.ui.graphics.Brush
import zed.rainxch.plmayminichallenges2025.study_feed_switcher.domain.model.QuickLesson
import zed.rainxch.plmayminichallenges2025.study_feed_switcher.presentation.utils.getGradientByKey

data class QuickLessonUI(
    val title: String,
    val description: String,
    val subject: String,
    val gradient: Brush
)

fun QuickLesson.toQuickLessonUI(): QuickLessonUI {
    return QuickLessonUI(
        title = this.title,
        description = this.description,
        subject = this.subject,
        gradient = getGradientByKey(this.gradient),
    )
}