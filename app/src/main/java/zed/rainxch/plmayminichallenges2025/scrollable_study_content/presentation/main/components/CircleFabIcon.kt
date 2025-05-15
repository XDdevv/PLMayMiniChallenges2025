package zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun CircleFabIcon(
    painter: Painter,
    iconTint: Color,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick : () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable {
                onClick()
            }
    ) {
        Icon(
            painter = painter,
            contentDescription = "Up Icon",
            modifier = Modifier.size(32.dp),
            tint = iconTint
        )
    }
}