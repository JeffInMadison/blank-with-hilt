package com.jeffalexander.blankwithhilt.ui.main

sealed interface MainUiState {
    data object Loading : MainUiState

    data class Success(
        val data: Int
    ) : MainUiState

    data object Failed : MainUiState
}