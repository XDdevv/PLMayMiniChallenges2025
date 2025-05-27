package zed.rainxch.plmayminichallenges2025.searchable_study_list.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import zed.rainxch.plmayminichallenges2025.R
import zed.rainxch.plmayminichallenges2025.core.ui.theme.PLMayMiniChallenges2025Theme
import zed.rainxch.plmayminichallenges2025.core.ui.theme.SearchableStudyTheme
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratLightFont
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratSemiBoldFont
import zed.rainxch.plmayminichallenges2025.searchable_study_list.domain.model.studyTopics
import zed.rainxch.plmayminichallenges2025.searchable_study_list.presentation.components.TopicItem
import zed.rainxch.plmayminichallenges2025.searchable_study_list.presentation.vm.SearchableStudyListViewModel

@Composable
fun SearchableStudyListScreen(modifier: Modifier = Modifier) {
    val viewModel = viewModel<SearchableStudyListViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val list by viewModel.filteredList.collectAsState(studyTopics)
    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.study_topics),
                    fontFamily = montserratSemiBoldFont,
                    fontSize = 22.sp
                )
                BasicTextField(
                    value = searchText,
                    textStyle = TextStyle(
                        fontFamily = montserratLightFont,
                        fontSize = 18.sp,
                        color = SearchableStudyTheme.colorSearchText
                    ),
                    onValueChange = { query ->
                        viewModel.search(query)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(SearchableStudyTheme.bgInput, CircleShape),
                    decorationBox = { content ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = stringResource(R.string.search_icon),
                                tint = SearchableStudyTheme.tintSearchIcon,
                                modifier = Modifier.padding(14.dp)
                            )
                            if (searchText.isNotEmpty()) {
                                content()
                            } else {
                                Text(
                                    text = "Search by topic or subject",
                                    fontSize = 16.sp,
                                    fontFamily = montserratLightFont
                                )
                            }
                        }
                    }
                )
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = SearchableStudyTheme.bgGradient)
                    .padding(20.dp)
            ) {
                items(
                    items = list,
                    key = { it.title.hashCode().toString() }
                ) { item ->
                    TopicItem(item, Modifier.animateItemPlacement())
                }
            }
        }
    }
}

@Preview
@Composable
private fun SearchableStudyListScreenPreview() {
    SearchableStudyListScreen()
}