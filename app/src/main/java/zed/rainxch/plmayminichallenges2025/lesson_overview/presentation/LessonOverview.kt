package zed.rainxch.plmayminichallenges2025.lesson_overview.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.R
import zed.rainxch.plmayminichallenges2025.lesson_overview.domain.model.Author
import zed.rainxch.plmayminichallenges2025.lesson_overview.domain.model.Category
import zed.rainxch.plmayminichallenges2025.lesson_overview.domain.model.Lesson
import zed.rainxch.plmayminichallenges2025.lesson_overview.presentation.components.AuthorCard
import zed.rainxch.plmayminichallenges2025.lesson_overview.presentation.components.CategoryItem
import zed.rainxch.plmayminichallenges2025.lesson_overview.presentation.components.GonnaLearnItem
import zed.rainxch.plmayminichallenges2025.core.ui.theme.LessonOverviewColors
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratLightFont
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratSemiBoldFont
import zed.rainxch.plmayminichallenges2025.core.ui.theme.poltawskiFont

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LessonOverview(
    lesson: Lesson,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val isTablet = screenWidthDp >= 600
    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LessonOverviewColors.BackgroundPurplePillTextIconColor.color)
                .padding(top = innerPadding.calculateTopPadding() + 16.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                )
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = lesson.title,
                fontSize = 34.sp,
                fontFamily = poltawskiFont,
                textAlign = if (isTablet) TextAlign.Center else TextAlign.Start,
                color = LessonOverviewColors.PrimaryText.color
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = lesson.description,
                fontSize = 16.sp,
                fontFamily = montserratLightFont,
                textAlign = if (isTablet) TextAlign.Center else TextAlign.Start,
                modifier = Modifier.padding(horizontal = if (isTablet) 32.dp else 0.dp),
                color = LessonOverviewColors.SecondaryText.color,
            )
            Spacer(Modifier.height(16.dp))
            FlowRow {
                for (category in lesson.categories) {
                    CategoryItem(
                        category = category,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

            HorizontalDivider(Modifier.padding(bottom = 16.dp))

            Text(
                text = "What you'll learn:",
                modifier = Modifier.align(Alignment.Start),
                fontFamily = montserratSemiBoldFont,
                fontSize = 18.sp,
                color = LessonOverviewColors.PrimaryText.color,
            )

            Spacer(Modifier.height(12.dp))

            LazyColumn {
                items(lesson.gonnaLearnList) { gonnaLearn ->
                    GonnaLearnItem(item = gonnaLearn)
                }
            }

            Spacer(Modifier.weight(1f))

            AuthorCard(lesson.author)
        }
    }
}

@Preview
@Preview(heightDp = 1280, widthDp = 800)
@Composable
private fun LessonOverviewPreview() {
    LessonOverview(
        lesson = lessonPreview
    )
}

internal val lessonPreview = Lesson(
    title = "Physics Crash Course",
    description = "The Physics Crash Course offers a foundational overview of essential concepts, teaching learners to understand Newton’s three laws of motion, explain the principle of energy conservation, distinguish between kinetic and potential energy with real-world examples, solve basic problems involving force and mass, and apply the concept of momentum in everyday situations.",
    categories = listOf(
        Category.Filled(
            backgroundColor = Color(0xffEFEFFC),
            textColor = Color(0xff6B74F8),
            hasIcon = true,
            iconRes = R.drawable.ic_intermidate,
            content = "Intermediate"
        ),
        Category.Filled(
            backgroundColor = Color(0xffE5FBF2),
            textColor = Color(0xff03A564),
            hasIcon = false,
            content = "Science"
        ),
        Category.Filled(
            backgroundColor = Color(0xffE5FBF2),
            textColor = Color(0xff03A564),
            hasIcon = false,
            content = "Physics"
        ),
        Category.Outlined(true, R.drawable.ic_time, "15 mins")
    ),
    gonnaLearnList = listOf(
        "Understand Newton's three laws of motion",
        "Explain the principle of energy conservation",
        "Identify real-world examples of kinetic and potential energy",
        "Solve simple physics problems involving force and mass",
        "Apply concepts of momentum in everyday scenarios",
    ),
    author = Author("Dr. Eleanor Maxwell", R.drawable.author)
)