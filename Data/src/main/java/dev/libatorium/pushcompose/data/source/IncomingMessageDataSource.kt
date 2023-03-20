package dev.libatorium.pushcompose.data.source

import dev.libatorium.pushcompose.data.model.Message
import kotlinx.coroutines.flow.StateFlow

interface IncomingMessageDataSource {
    val messageFlow: StateFlow<Message>
    fun onNewMessage(message: Message)
}
