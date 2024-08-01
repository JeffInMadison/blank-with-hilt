package com.jeffalexander.blankwithhilt.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jeffalexander.blankwithhilt.ui.theme.BlankWithHiltTheme

@Composable
fun FailedScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            text = "Failed Loading Items!",
            color = MaterialTheme.colorScheme.error,
        )
    }
}

@Preview
@Composable
fun FailedScreen_Preview() {
    BlankWithHiltTheme {
        Surface {
            FailedScreen()
        }
    }
}