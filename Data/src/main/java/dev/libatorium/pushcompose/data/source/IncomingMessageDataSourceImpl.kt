package dev.libatorium.pushcompose.data.source

import dev.libatorium.pushcompose.common.IoDispatcher
import dev.libatorium.pushcompose.data.model.Message
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

class IncomingMessageDataSourceImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : IncomingMessageDataSource {
    override val messageFlow: Flow<Message>
        get() {
            val msgs = (1..10).map { Message("$it") }.toTypedArray()
            return flowOf(*msgs).onEach { delay(1000L) }.flowOn(dispatcher)
        }

    override fun onMessageReceived() {
        TODO("Not yet implemented")
    }
}
