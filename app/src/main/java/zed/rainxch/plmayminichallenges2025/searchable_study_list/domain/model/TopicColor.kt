package zed.rainxch.plmayminichallenges2025.searchable_study_list.domain.model

import androidx.compose.ui.graphics.Color

enum class TopicColor(
    val bgColor: Color,
    val contentColor: Color
) {
    GREEN(
        bgColor = Color(0xffE5FBF2),
        contentColor = Color(0xff03A564)
    ),
    PURPLE(
        bgColor = Color(0xffEFEFFC),
        contentColor = Color(0xff6B74F8)
    ),
    ORANGE(
        bgColor = Color(0xffFCF5EF),
        contentColor = Color(0xffF78018)
    ),
    RED(
        bgColor = Color(0xffFDE5F3),
        contentColor = Color(0xffDC3C9A)
    )
}