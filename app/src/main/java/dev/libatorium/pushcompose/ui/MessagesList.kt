package dev.libatorium.pushcompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.libatorium.pushcompose.data.model.Message

@Composable
fun MessagesList(
    messages: List<Message>
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(messages) {
            MessageItem(message = it)
        }
    }
}

@Composable
@Preview
private fun MessagesListPreview() {
    val messages = listOf(
        Message("Hello 1"),
        Message("Hello 2"),
        Message("Hello 3")
    )
    MessagesList(messages = messages)
}
