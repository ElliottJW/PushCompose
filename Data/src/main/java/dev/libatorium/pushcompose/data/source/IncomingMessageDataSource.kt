package dev.libatorium.pushcompose.data.source

import dev.libatorium.pushcompose.data.model.Message
import kotlinx.coroutines.flow.Flow

interface IncomingMessageDataSource {
    val messageFlow: Flow<Message>
    fun onMessageReceived()
}
