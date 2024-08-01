package com.jeffalexander.blankwithhilt.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jeffalexander.blankwithhilt.ui.main.MainUiState
import com.jeffalexander.blankwithhilt.ui.main.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val mainUiState by viewModel.mainUiState.collectAsState()

    MainScreenContent(
        mainUiState = mainUiState,
        modifier = modifier,
    )
}

@ExperimentalMaterial3Api
@Composable
fun MainScreenContent(
    mainUiState: MainUiState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Blank App")
                },
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = Color.Red,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = Color.Magenta,
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            when (mainUiState) {
                MainUiState.Failed -> FailedScreen()
                MainUiState.Loading -> LoadingScreen()
                is MainUiState.Success -> {
                    Text(text = "${mainUiState.data} is the magic number")
                }
            }
        }
    }
}
