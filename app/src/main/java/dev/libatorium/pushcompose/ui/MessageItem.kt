package dev.libatorium.pushcompose.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.libatorium.pushcompose.data.model.Message

@Composable
fun MessageItem(message: Message) {
    ElevatedCard(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(16.dp)) {
            Text(text = message.title)
        }
    }
}

@Preview
@Composable
private fun MessageItemPreview() {
    MessageItem(message = Message("Hello, World!"))
}
