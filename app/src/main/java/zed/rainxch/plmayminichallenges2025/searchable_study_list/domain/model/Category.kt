package zed.rainxch.plmayminichallenges2025.searchable_study_list.domain.model

import androidx.compose.ui.graphics.Color

data class Category(
    val category: String,
    val color: TopicColor
)

fun List<String>.toCategories(): List<Category> {
    return this.map { category ->
        Category(
            category = category,
            color = getColorByCategory(category)
        )
    }
}

fun getColorByCategory(category: String): TopicColor {
    return when (category) {
        "Biology" -> TopicColor.GREEN
        "Environmental Science" -> TopicColor.PURPLE
        "History" -> TopicColor.GREEN
        "Social Studies" -> TopicColor.ORANGE
        "Math" -> TopicColor.RED
        "Literature" -> TopicColor.RED
        "Language Arts" -> TopicColor.PURPLE
        "Geography" -> TopicColor.ORANGE
        "Language" -> TopicColor.ORANGE
        "French" -> TopicColor.PURPLE
        "Health" -> TopicColor.PURPLE
        "Spanish" -> TopicColor.RED
        "Earth Science" -> TopicColor.GREEN
        "Archaeology" -> TopicColor.ORANGE
        "Writing" -> TopicColor.PURPLE
        "Civics" -> TopicColor.GREEN
        "English" -> TopicColor.ORANGE
        "Science" -> TopicColor.PURPLE
        "Computer Science" -> TopicColor.ORANGE
        "Technology" -> TopicColor.GREEN
        "Grammar" -> TopicColor.RED
        "Ecology" -> TopicColor.GREEN
        "Astronomy" -> TopicColor.ORANGE
        else -> TopicColor.RED
    }
}