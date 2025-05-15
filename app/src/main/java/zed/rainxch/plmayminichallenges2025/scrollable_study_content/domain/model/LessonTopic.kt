package zed.rainxch.plmayminichallenges2025.scrollable_study_content.domain.model

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class LessonTopic(
    val title: String,
    val category: String,
    val isPinned: Boolean = false
)