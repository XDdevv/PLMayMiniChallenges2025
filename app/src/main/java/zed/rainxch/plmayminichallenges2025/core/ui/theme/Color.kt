package zed.rainxch.plmayminichallenges2025.core.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

object LessonTopicStudyTheme {
    const val PRIMARY = 0xff6B74F8
    const val PRIMARY_TEXT = 0xff13182C
    const val SECONDARY_TEXT = 0xff6B74F8
    const val TERTIARY_TEXT = 0xff6B74F8
    const val HIGHER_SURFACE = 0xffEFEFFC
    const val ICON = 0xff6B74F8
    const val HEADLINE_BACKGROUND = 0xffE4E4FE

    val BACKGROUND_BRUSH = SolidColor(Color(0x276B74F8))
}

enum class LessonOverviewColors(val color: Color) {
    BackgroundPurplePillTextIconColor(Color(0xff6B74F8)),
    PurplePillBG(Color(0xffEFEFFC)),
    GreenPillTextIconColor(Color(0xff03A564)),
    GreenPillBG(Color(0xffE5FBF2)),
    TealPillTextIconColor(Color(0xff07A8A2)),
    TealPillBG(Color(0xffEFFCFB)),
    PinkPillTextIconColor(Color(0xffDC3C9A)),
    PinkPillBG(Color(0xffFDE5F3)),
    PrimaryText(Color(0xff13182C)),
    SecondaryText(Color(0xff4C4F59)),
    Stroke(Color(0xffE5E5E9)),
    CardBG(Color(0xffFFFFFF)),
    TeacherPillBG(Color(0x4DF9E2F3))
}

fun Long.toColor(): Color {
    return Color(this)
}