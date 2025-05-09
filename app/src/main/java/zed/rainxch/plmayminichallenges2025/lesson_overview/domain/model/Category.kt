package zed.rainxch.plmayminichallenges2025.lesson_overview.domain.model

import androidx.compose.ui.graphics.Color

sealed class Category {
    data class Outlined(
        val hasIcon: Boolean = true,
        val iconRes: Int = 0,
        val content: String
    ) : Category()

    data class Filled(
        val backgroundColor: Color,
        val textColor: Color,
        val hasIcon: Boolean = false,
        val iconRes: Int = 0,
        val content: String
    ) : Category()
}
