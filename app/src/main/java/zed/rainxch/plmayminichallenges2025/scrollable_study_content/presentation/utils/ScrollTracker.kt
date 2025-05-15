package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.utils

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.mutableStateOf

class ScrollTracker(private val listState: LazyListState) {
    private var isProgrammaticScrollInProgress = mutableStateOf(false)
    private var isManualScrolling = mutableStateOf(false)

    fun isProgrammaticScroll() = isProgrammaticScrollInProgress.value

    fun startProgrammaticScroll() {
        isProgrammaticScrollInProgress.value = true
        isManualScrolling.value = false
    }

    fun startManualScroll() {
        if (!isProgrammaticScrollInProgress.value) {
            isManualScrolling.value = true
        }
    }

    fun resetScrollState() {
        isProgrammaticScrollInProgress.value = false
    }
}