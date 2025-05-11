package zed.rainxch.plmayminichallenges2025.study_feed_switcher.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmayminichallenges2025.core.ui.theme.montserratSemiBoldFont

@Composable
fun TextChip(
    content: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color(0x51FFFFFF))
            .padding(vertical = 2.dp, horizontal = 12.dp)
    ) {
        Text(
            text = content,
            color = Color.White,
            fontFamily = montserratSemiBoldFont,
            fontSize = 15.sp
        )
    }
}

@Preview
@Composable
private fun TextChipPreview() {
    TextChip(
        content = "Biologiya"
    )
}