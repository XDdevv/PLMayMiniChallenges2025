package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import zed.rainxch.plmayminichallenges2025.R
import zed.rainxch.plmayminichallenges2025.core.presentation.components.TextChip
import zed.rainxch.plmayminichallenges2025.core.ui.theme.LessonTopicStudyTheme
import zed.rainxch.plmayminichallenges2025.core.ui.theme.LessonTopicStudyTheme.HEADLINE_BACKGROUND
import zed.rainxch.plmayminichallenges2025.core.ui.theme.toColor
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.domain.model.LessonTopic
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.components.CircleFabIcon
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.components.HeadlineText
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.components.LessonTopicItem
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.components.ListHorizontalProgressbar
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.vm.ScrollableStudyMainViewModel
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.utils.ScrollTracker

const val FIRST_INDEX = 0

@Composable
fun ScrollableStudyMainScreen(
    onNavigateToDetailsScreen: (LessonTopic) -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<ScrollableStudyMainViewModel>()
    val context = LocalContext.current

    val snackState = SnackbarHostState()
    val mainListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val lessonsList = viewModel.categorizedLessonsList
    val categoryList = viewModel.categoryList
    val pinnedLessonsList = viewModel.pinnedList

    val showFABButton = viewModel.showFABButton
    val showReadingEndMessage = viewModel.showReachingEndMessage
    val showTooMuchPinsMessage = viewModel.showTooMuchPinsMessage

    val scrollTracker = remember { ScrollTracker(mainListState) }

    LaunchedEffect(mainListState) {
        launch {
            snapshotFlow { mainListState.isScrollInProgress }
                .collect { isScrolling ->
                    if (!isScrolling) {
                        scrollTracker.resetScrollState()
                    }
                }
        }
        launch {
            snapshotFlow { mainListState.firstVisibleItemIndex }
                .collect { index ->
                    if (!scrollTracker.isProgrammaticScroll() && mainListState.isScrollInProgress) {
                        scrollTracker.startManualScroll()
                        viewModel.setManuallyScroll(true)
                    }

                    viewModel.checkReachEndState(mainListState)
                    viewModel.checkShowFABButton(index)
                }
        }
    }

    val userScrollListener = Modifier.touchEventCallback {
        if (mainListState.isScrollInProgress) {
            scrollTracker.startManualScroll()
            viewModel.setManuallyScroll(true)
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackState) }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(LessonTopicStudyTheme.BACKGROUND_BRUSH)
                .padding(innerPadding)
        ) {
            Column {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {
                    LazyRow(
                        modifier = Modifier.padding(12.dp),
                    ) {
                        itemsIndexed(categoryList) { index, category ->
                            TextChip(
                                content = category,
                                backgroundColor = Color.White,
                                textColor = Color.Black,
                                modifier = Modifier
                            ) {
                                val categoryIndex = viewModel.getIndexByCategory(index, category)
                                coroutineScope.launch {
                                    scrollTracker.startProgrammaticScroll()
                                    viewModel.setManuallyScroll(false)
                                    mainListState.animateScrollToItem(categoryIndex)
                                }
                            }
                        }
                    }

                    ListHorizontalProgressbar(
                        scrollState = mainListState
                    )
                    LazyColumn (
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                    ) {
                        itemsIndexed(pinnedLessonsList) { index, lesson ->
                            LessonTopicItem(
                                lessonTopic = lesson,
                                onItemClicked = {

                                    onNavigateToDetailsScreen(lesson)
                                },
                                onPinClicked = { newPinnedState ->
                                    viewModel.handlePinnedLesson(newPinnedState, index, lesson)
                                }
                            )
                        }
                    }

                }

                LazyColumn(
                    state = mainListState,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .then(userScrollListener),
                ) {

                    lessonsList.forEachIndexed { index, (category, groupedList) ->
                        stickyHeader {
                            HeadlineText(
                                text = category,
                                backgroundColor = HEADLINE_BACKGROUND.toColor()
                            )
                        }

                        itemsIndexed(groupedList) { index, lesson ->
                            LessonTopicItem(
                                lessonTopic = lesson,
                                onItemClicked = {
                                    onNavigateToDetailsScreen(lesson)
                                },
                                onPinClicked = { newPinnedState ->
                                    viewModel.handlePinnedLesson(newPinnedState, index, lesson)
                                }
                            )

                        }
                    }
                }
            }

            if (showFABButton) {
                CircleFabIcon(
                    painter = painterResource(R.drawable.ic_arrow_up),
                    iconTint = LessonTopicStudyTheme.PRIMARY.toColor(),
                    backgroundColor = LessonTopicStudyTheme.HIGHER_SURFACE.toColor(),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(12.dp),
                    onClick = {
                        coroutineScope.launch {
                            // Mark as programmatic scroll before scrolling to top
                            scrollTracker.startProgrammaticScroll()
                            viewModel.setManuallyScroll(false)
                            mainListState.animateScrollToItem(FIRST_INDEX)
                        }
                    }
                )
            }

            LaunchedEffect(viewModel.didManuallyScroll, showReadingEndMessage) {
                if (viewModel.didManuallyScroll && showReadingEndMessage) {
                    snackState.showSnackbar(context.getString(R.string.reaching_the_end_of_the_list))
                }
            }

            LaunchedEffect(showTooMuchPinsMessage) {
                if (showTooMuchPinsMessage) {
                    snackState.showSnackbar(context.getString(R.string.you_reached_the_max_limit_of_pinning_lessons_max_is_5))
                }
            }
        }
    }
}

fun Modifier.touchEventCallback(onTouch: () -> Unit): Modifier {
    return this.then(
        Modifier.pointerInteropFilter {
            onTouch()
            println(it.y)
            false
        }
    )
}

@Preview
@Composable
private fun ScrollableStudyMainScreenPreview() {
    ScrollableStudyMainScreen(
        onNavigateToDetailsScreen = { }
    )
}