package zed.rainxch.plmayminichallenges2025.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
    backgroundColor: Color = Color(0x51FFFFFF),
    textColor: Color = Color.White,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .padding(end = 8.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable {
                onClick()
            }
            .padding(vertical = 2.dp, horizontal = 12.dp)

    ) {
        Text(
            text = content,
            color = textColor,
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