package com.jeffalexander.blankwithhilt.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {
    private val uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState.Loading)
    val mainUiState = uiState.asStateFlow()

    init {
        uiState.update { MainUiState.Loading }

        viewModelScope.launch {
            uiState.update { MainUiState.Success(3) }
        }
    }
}