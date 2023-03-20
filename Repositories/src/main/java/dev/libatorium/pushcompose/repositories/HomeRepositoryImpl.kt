package dev.libatorium.pushcompose.repositories

import dev.libatorium.pushcompose.common.ApplicationScope
import dev.libatorium.pushcompose.data.model.Message
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSource
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.sync.Mutex

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val messageDataSource: IncomingMessageDataSource,
    @ApplicationScope private val externalScope: CoroutineScope
) : HomeRepository {

    private val allMessagesMutex = Mutex()
    private val _allMessages: MutableList<Message> = mutableListOf()

    override val allMessagesFlow: Flow<List<Message>> =
        messageDataSource.messageFlow.map { msg ->
            _allMessages += msg
            _allMessages
        }
}
