package zed.rainxch.plmayminichallenges2025.searchable_study_list.domain.model

data class Category(
    val category: String,
    val color: TopicColor
)

fun List<String>.toCategories(): List<Category> {
    return this.map { category ->
        Category(
            category = category,
            color = TopicColor.entries.random()
        )
    }
}