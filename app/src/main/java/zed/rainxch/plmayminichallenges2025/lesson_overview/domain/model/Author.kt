package zed.rainxch.plmayminichallenges2025.lesson_overview.domain.model

import androidx.annotation.DrawableRes

data class Author(
    val fullName: String,
    @DrawableRes val profilePicId: Int
)
