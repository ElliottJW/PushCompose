package dev.libatorium.pushcompose.repositories

import dev.libatorium.pushcompose.common.IoDispatcher
import dev.libatorium.pushcompose.data.model.Message
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSource
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val messageDataSource: IncomingMessageDataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : HomeRepository {

    private val allMessagesMutex = Mutex()
    private val _allMessages: MutableList<Message> = mutableListOf()
    override val allMessagesFlow: Flow<List<Message>> =
        messageDataSource.messageFlow.map { msg ->
            allMessagesMutex.withLock {
                _allMessages += msg
                _allMessages
            }
        }.flowOn(dispatcher)
}
