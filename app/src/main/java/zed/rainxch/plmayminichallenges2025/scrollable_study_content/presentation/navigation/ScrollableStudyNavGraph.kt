package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.navigation

import kotlinx.serialization.Serializable
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.domain.model.LessonTopic

@Serializable
sealed class ScrollableStudyNavGraph {

    @Serializable
    object MainScreen : ScrollableStudyNavGraph()

    @Serializable
    data class CourseDetailsScreen(val lessonTopic: LessonTopic) : ScrollableStudyNavGraph()
}