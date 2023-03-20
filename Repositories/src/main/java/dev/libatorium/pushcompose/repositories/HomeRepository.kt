package dev.libatorium.pushcompose.repositories

import dev.libatorium.pushcompose.data.model.Message
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    val allMessagesFlow: Flow<List<Message>>
}
