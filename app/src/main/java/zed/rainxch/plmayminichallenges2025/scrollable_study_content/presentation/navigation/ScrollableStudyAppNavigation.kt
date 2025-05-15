package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.serializer
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.domain.model.LessonTopic
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.details.CourseDetailsScreen
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.ScrollableStudyMainScreen
import kotlin.reflect.typeOf

@Composable
fun ScrollableStudyAppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScrollableStudyNavGraph.MainScreen
    ) {
        composable<ScrollableStudyNavGraph.MainScreen> (

        ) {
            ScrollableStudyMainScreen(
                onNavigateToDetailsScreen = { lesson ->
                    navController.navigate(ScrollableStudyNavGraph.CourseDetailsScreen(lesson))
                }
            )
        }

        composable<ScrollableStudyNavGraph.CourseDetailsScreen> (
            typeMap = mapOf(
                typeOf<LessonTopic>() to NavTypeSerializer.create(serializer<LessonTopic>()),
                typeOf<List<LessonTopic>>() to NavTypeSerializer.create(serializer<List<LessonTopic>>()),
                typeOf<String>() to NavTypeSerializer.create(serializer<String>()),
            )
        ) { backStackEntry ->
            val args = backStackEntry.toRoute<ScrollableStudyNavGraph.CourseDetailsScreen>()
            CourseDetailsScreen(
                lessonTopic = args.lessonTopic,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}