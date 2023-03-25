package dev.libatorium.pushcompose.repositories

import dev.libatorium.pushcompose.data.model.Message
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSource
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Singleton
class HomeRepositoryImpl @Inject constructor(
    messageDataSource: IncomingMessageDataSource
) : HomeRepository {

    private val _allMessages: MutableList<Message> = mutableListOf()

    override val allMessagesFlow: Flow<List<Message>> =
        messageDataSource.messageFlow.map { msg ->
            _allMessages += msg
            _allMessages
        }
}
