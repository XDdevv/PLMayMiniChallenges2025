package zed.rainxch.plmayminichallenges2025.searchable_study_list.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn
import zed.rainxch.plmayminichallenges2025.searchable_study_list.domain.model.studyTopics

class SearchableStudyListViewModel : ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val allTopics = MutableStateFlow(studyTopics)

    @OptIn(FlowPreview::class)
    val filteredList = combine(allTopics, _searchText) { allTopics, query ->
        if (query.isEmpty()) {
            allTopics
        } else {
            allTopics.filter { topic ->
                topic.title.startsWith(query, ignoreCase = true) ||
                        topic.categories.any { it.category.startsWith(query, ignoreCase = true) }
            }
        }
    }
        .debounce(300L)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), studyTopics)

    fun search(query: String) {
        _searchText.value = query
    }
}