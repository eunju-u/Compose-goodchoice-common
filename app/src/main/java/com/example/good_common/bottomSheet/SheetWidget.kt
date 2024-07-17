package com.example.good_common.bottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.draw.clip
import com.example.good_common.theme.Theme
import com.example.good_common.theme.dp0
import com.example.good_common.theme.dp40
import com.example.good_common.theme.dp5
import com.example.good_common.theme.dp6
import com.example.good_common.theme.dp8

@Composable
fun SheetWidget(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(dp0),
    hasIndicator: Boolean = true,
    content: @Composable @UiComposable ColumnScope.() -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clip(shape)
                .background(Theme.colorScheme.white),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (hasIndicator) {
                Box(
                    modifier = Modifier
                        .padding(top = dp8)
                        .size(width = dp40, height = dp6)
                        .background(
                            color = Theme.colorScheme.pureGray,
                            shape = RoundedCornerShape(dp5)
                        )
                )
            }
            content()
        }

    }
}