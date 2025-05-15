package zed.rainxch.plmayminichallenges2025.study_feed_switcher.presentation

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.core.presentation.components.TextChip
import zed.rainxch.plmayminichallenges2025.study_feed_switcher.presentation.data.quickLessonsUI
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratLightFont
import zed.rainxch.plmayminichallenges2025.core.ui.theme.poltawskiFont

@Composable
fun StudyFeetSwitcherScreen(
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == ORIENTATION_PORTRAIT
    val lessonsList = remember { quickLessonsUI }
    var currentIndex by rememberSaveable { mutableIntStateOf(0) }
    val currentItem = lessonsList.getOrNull(currentIndex) ?: return

    val upIcon =
        if (isPortrait) Icons.Default.KeyboardArrowUp else Icons.AutoMirrored.Filled.KeyboardArrowLeft
    val downIcon =
        if (isPortrait) Icons.Default.KeyboardArrowDown else Icons.AutoMirrored.Filled.KeyboardArrowRight

    val upIconAlignment = if (isPortrait) Alignment.TopCenter else Alignment.CenterStart
    val downIconAlignment = if (isPortrait) Alignment.BottomCenter else Alignment.CenterEnd

    val showSwipeToSeeMore by remember { mutableStateOf(true) }

    fun incrementCurrentIndex() {
        if (currentIndex == lessonsList.lastIndex) {
            currentIndex = 0
        } else currentIndex++
    }

    fun decrementCurrentIndex() {
        if (currentIndex <= 0) {
            currentIndex = lessonsList.lastIndex
        } else currentIndex--
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing
    ) { innerPadding ->

        Crossfade(targetState = currentItem) { currentItem ->
            // DRAGGING VARS
            var totalDrag by remember { mutableFloatStateOf(0f) }
            val dragThreshold = 500f

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(currentItem.gradient)
                    .padding(innerPadding)
                    .pointerInput(Unit) {
                        if (isPortrait) {
                            detectVerticalDragGestures(
                                onVerticalDrag = { _, dragAmount ->
                                    totalDrag += dragAmount
                                },
                                onDragEnd = {
                                    if (totalDrag < -dragThreshold) {
                                        incrementCurrentIndex()
                                    } else if (totalDrag > dragThreshold) {
                                        decrementCurrentIndex()
                                    }
                                    totalDrag = 0f
                                }

                            )
                        } else {
                            detectHorizontalDragGestures(
                                onHorizontalDrag = { _, dragAmount ->
                                    totalDrag += dragAmount
                                },

                                onDragEnd = {
                                    if (totalDrag < -dragThreshold) {
                                        incrementCurrentIndex()
                                    } else if (totalDrag > dragThreshold) {
                                        decrementCurrentIndex()
                                    }
                                    totalDrag = 0f
                                }

                            )
                        }
                    }
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(upIconAlignment),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = upIcon,
                        contentDescription = "Up",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color.White,
                    )
                    if (showSwipeToSeeMore && isPortrait) {
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "Swipe to see more",
                            fontSize = 20.sp,
                            fontFamily = montserratLightFont,
                            color = Color.White
                        )
                    }
                }

                if (showSwipeToSeeMore && !isPortrait) {
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Swipe to see more",
                        fontSize = 20.sp,
                        fontFamily = montserratLightFont,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.TopCenter)
                    )
                }

                Column(
                    modifier = Modifier
                        .height(308.dp)
                        .width(640.dp)
                        .align(Alignment.BottomCenter)
                        .padding(32.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    TextChip(
                        content = currentItem.subject,
                        modifier = Modifier.padding(
                            vertical = 2.dp,
                            horizontal = 12.dp
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = currentItem.title,
                        fontFamily = poltawskiFont,
                        fontSize = 38.sp,
                        color = Color.White
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = currentItem.description,
                        fontFamily = montserratLightFont,
                        fontSize = 19.sp,
                        color = Color.White
                    )
                }

                Icon(
                    imageVector = downIcon,
                    contentDescription = "Down",
                    modifier = Modifier
                        .padding(20.dp)
                        .size(32.dp)
                        .align(downIconAlignment),
                    tint = Color.White
                )
            }

        }
    }
}


@Preview
@Composable
fun StudyFeetSwitcherScreenPreview(modifier: Modifier = Modifier) {
    StudyFeetSwitcherScreen()
}