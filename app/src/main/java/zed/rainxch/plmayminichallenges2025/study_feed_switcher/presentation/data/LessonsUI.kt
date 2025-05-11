package zed.rainxch.plmayminichallenges2025.study_feed_switcher.presentation.data

import zed.rainxch.plmayminichallenges2025.study_feed_switcher.data.quickLessons
import zed.rainxch.plmayminichallenges2025.study_feed_switcher.presentation.model.toQuickLessonUI

val quickLessonsUI = quickLessons.map { it.toQuickLessonUI() }
