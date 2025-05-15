package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.core.ui.theme.LessonTopicStudyTheme
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratSemiBoldFont
import zed.rainxch.plmayminichallenges2025.core.ui.theme.poltawskiFont
import zed.rainxch.plmayminichallenges2025.core.ui.theme.toColor
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.domain.model.LessonTopic
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.details.components.CategoryItem

@Composable
fun CourseDetailsScreen(
    lessonTopic: LessonTopic,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LessonTopicStudyTheme.PRIMARY.toColor())
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LessonTopicStudyTheme.PRIMARY.toColor())
                    .padding(4.dp)
            ) {
                IconButton(
                    onClick = { onNavigateBack() },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Icon back",
                        tint = Color.White
                    )
                }

                Text(
                    text = "Course Details",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = montserratSemiBoldFont,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Column(
                modifier = Modifier.fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = lessonTopic.title,
                    fontFamily = poltawskiFont,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    color = LessonTopicStudyTheme.PRIMARY_TEXT.toColor(),
                    maxLines = 1
                )
                Spacer(Modifier.height(16.dp))
                CategoryItem(
                    content = lessonTopic.category,
                    backgroundColor = Color(0xffE5FBF2),
                    textColor = Color(0xff03A564)
                )
            }
        }

    }
}