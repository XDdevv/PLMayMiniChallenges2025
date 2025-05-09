package zed.rainxch.plmayminichallenges2025.lesson_overview.domain.model

data class Lesson(
    val title: String,
    val description: String,
    val categories: List<Category>,
    val gonnaLearnList: List<String>,
    val author: Author
)
