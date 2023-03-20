package dev.libatorium.pushcompose.data.source

import dev.libatorium.pushcompose.data.model.Message
import kotlinx.coroutines.flow.SharedFlow

interface IncomingMessageDataSource {
    val messageFlow: SharedFlow<Message>
    fun onNewMessage(message: Message)
}
