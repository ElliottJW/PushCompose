package dev.libatorium.pushcompose.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import dev.libatorium.pushcompose.data.model.Message

@Composable
fun MessagesList(
    messages: List<Message>
) {
    LazyColumn {
        items(messages) {
            MessageItem(message = it)
        }
    }
}
