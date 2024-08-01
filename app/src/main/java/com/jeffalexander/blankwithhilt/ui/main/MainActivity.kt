package com.jeffalexander.blankwithhilt.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jeffalexander.blankwithhilt.ui.components.MainScreen
import com.jeffalexander.blankwithhilt.ui.theme.BlankWithHiltTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlankWithHiltTheme {
                val mainViewModel: MainViewModel = viewModel()
                MainScreen(viewModel = mainViewModel)
            }
        }
    }
}
