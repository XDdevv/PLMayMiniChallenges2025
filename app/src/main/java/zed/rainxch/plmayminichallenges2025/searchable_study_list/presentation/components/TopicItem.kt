package zed.rainxch.plmayminichallenges2025.searchable_study_list.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.core.presentation.components.TextChip
import zed.rainxch.plmayminichallenges2025.core.ui.theme.poltawskiFont
import zed.rainxch.plmayminichallenges2025.searchable_study_list.domain.model.SearchableStudyItem

@Composable
fun TopicItem(
    searchableStudyItem: SearchableStudyItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        FlowRow {
            searchableStudyItem.categories.forEach { it ->
                TextChip(
                    content = it.category,
                    backgroundColor = it.color.bgColor,
                    contentColor = it.color.contentColor,
                )
            }
        }

        Text(
            text = searchableStudyItem.title,
            fontFamily = poltawskiFont,
            fontSize = 22.sp
        )
    }
}