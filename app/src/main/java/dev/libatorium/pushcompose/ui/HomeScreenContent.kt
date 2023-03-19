package dev.libatorium.pushcompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.libatorium.pushcompose.HomeViewModel

@Composable
fun HomeScreenContent(
    homeViewModel: HomeViewModel = viewModel()
) {
    val messages by homeViewModel.messagesListFlow.collectAsStateWithLifecycle()
    MessagesList(messages = messages)
}
