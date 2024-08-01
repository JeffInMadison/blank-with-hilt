package com.jeffalexander.blankwithhilt.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeffalexander.blankwithhilt.ui.theme.BlankWithHiltTheme

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(100.dp),
        )
        Text(
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            text = "Loading Items..."
        )
    }
}

@Preview
@Composable
fun LoadingScreen_Preview() {
    BlankWithHiltTheme {
        Surface {
            LoadingScreen()
        }
    }
}