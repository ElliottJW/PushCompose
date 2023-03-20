package dev.libatorium.pushcompose.repositories

import dev.libatorium.pushcompose.common.ApplicationScope
import dev.libatorium.pushcompose.data.model.Message
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSource
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val messageDataSource: IncomingMessageDataSource,
    @ApplicationScope private val externalScope: CoroutineScope
) : HomeRepository {

    private val allMessagesMutex = Mutex()
    private val _allMessages: MutableList<Message> = mutableListOf()
    override val allMessagesFlow: StateFlow<List<Message>> =
        messageDataSource.messageFlow.map { msg ->
            allMessagesMutex.withLock {
                _allMessages += msg
                _allMessages
            }
        }.stateIn(
            scope = externalScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )
}
