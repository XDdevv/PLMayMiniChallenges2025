package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.vm

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.data.lessonTopicList
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.domain.model.CategoryList
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.domain.model.LessonTopic

class ScrollableStudyMainViewModel : ViewModel() {
    var pinnedList = mutableStateListOf<LessonTopic>()
        private set

    var categorizedLessonsList = mutableStateListOf<CategoryList>()
        private set

    var categoryList by mutableStateOf<List<String>>(emptyList())

    var showReachingEndMessage by mutableStateOf<Boolean>(false)
    var didManuallyScroll by mutableStateOf<Boolean>(true)
    var showTooMuchPinsMessage by mutableStateOf<Boolean>(false)
    var showFABButton by mutableStateOf<Boolean>(false)

    init {
        val categoriesList = lessonTopicList.map { it.category }.distinct()
        categoryList = categoriesList
        initializeCategorizedList(categoriesList)
    }

    fun setManuallyScroll(value: Boolean) {
        didManuallyScroll = value
    }

    private fun initializeCategorizedList(categorizedList: List<String>) {
        categorizedLessonsList.addAll(categorizedList.map { category ->
            CategoryList(
                category = category,
                list = lessonTopicList.filter { it.category == category }
            )
        })
    }

    fun checkReachEndState(listState: LazyListState) {
        val totalItemsCount = listState.layoutInfo.totalItemsCount
        val lastVisibleItemIndex = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
        showReachingEndMessage = lastVisibleItemIndex >= totalItemsCount - 10
    }

    fun checkShowFABButton(firstVisibleItemIndex: Int) {
        showFABButton = firstVisibleItemIndex > 10
    }

    fun handlePinnedLesson(newPinnedState: Boolean, index: Int, lesson: LessonTopic) {
        if (newPinnedState) {
            addPinnedLesson(index, lesson)
        } else {
            removePinnedLesson(lesson)
        }
    }


    fun addPinnedLesson(index: Int, lesson: LessonTopic) {
        if (pinnedList.size < 5) {

            val category = lesson.category
            val lessonsList =
                categorizedLessonsList.find { it.category == category }?.list?.toMutableList()
                    ?: return
            val lessonsListIndex =
                categorizedLessonsList.indexOfFirst { it.category == category }
            if (lessonsListIndex == -1) return

            lessonsList.removeAt(index)

            categorizedLessonsList[lessonsListIndex] =
                categorizedLessonsList[lessonsListIndex].copy(list = lessonsList)

            if (pinnedList.none { it.title == lesson.title }) {
                val updatedLesson = lesson.copy(isPinned = true)
                pinnedList.add(updatedLesson)
            }
        } else {
            viewModelScope.launch {
                showTooMuchPinsMessage = true
                delay(3000)
                showTooMuchPinsMessage = false
            }
        }
    }

    fun removePinnedLesson(lesson: LessonTopic) {
        val category = lesson.category
        val lessonsList =
            categorizedLessonsList.find { it.category == category }?.list?.toMutableList() ?: return
        val lessonsListIndex =
            categorizedLessonsList.indexOfFirst { it.category == category }
        if (lessonsListIndex == -1) return
        val updatedLesson = lesson.copy(isPinned = false)

        lessonsList.add(0, updatedLesson)

        categorizedLessonsList[lessonsListIndex] =
            categorizedLessonsList[lessonsListIndex].copy(list = lessonsList)

        pinnedList.removeIf { it.title == lesson.title }
    }

    fun getIndexByCategory(index: Int, category: String): Int {
        return pinnedList.size + lessonTopicList.indexOfFirst { it.category == category } + index
    }
}