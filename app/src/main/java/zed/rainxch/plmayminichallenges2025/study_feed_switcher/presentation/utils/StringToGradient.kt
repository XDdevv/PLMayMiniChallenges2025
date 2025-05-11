package zed.rainxch.plmayminichallenges2025.study_feed_switcher.presentation.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor

fun getGradientByKey(key: String): Brush {
    return when (key) {
        "Leaf‑green gradient" -> Brush.linearGradient(listOf(
            Color(0xffAFD27A),
            Color(0xff287F3C)
        ))
        "Indigo gradient" -> Brush.linearGradient(listOf(
            Color(0xff1288FF),
            Color(0xff0B2299)
        ))
        "Amber gradient" -> Brush.linearGradient(listOf(
            Color(0xffF5C020),
            Color(0xffCF5B08)
        ))
        "Denim‑blue gradient" -> Brush.linearGradient(listOf(
            Color(0xff41A5CC),
            Color(0xff055270)
        ))
        "Coral gradient" -> Brush.linearGradient(listOf(
            Color(0xffFF9D89),
            Color(0xffD03515)
        ))
        "Teal gradient" -> Brush.linearGradient(listOf(
            Color(0xff41DDBE),
            Color(0xff087578)
        ))
        "Plum gradient" -> Brush.linearGradient(listOf(
            Color(0xff9E77AC),
            Color(0xff451C52)
        ))
        "Earth‑brown gradient" -> Brush.linearGradient(listOf(
            Color(0xff986241),
            Color(0xff402302)
        ))
        else -> SolidColor(Color.Gray)
    }
}