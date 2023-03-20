package dev.libatorium.pushcompose.repositories

import dev.libatorium.pushcompose.data.model.Message
import kotlinx.coroutines.flow.StateFlow

interface HomeRepository {
    val allMessagesFlow: StateFlow<List<Message>>
}
