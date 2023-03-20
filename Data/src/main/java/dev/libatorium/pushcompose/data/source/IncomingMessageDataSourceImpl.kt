package dev.libatorium.pushcompose.data.source

import dev.libatorium.pushcompose.common.ApplicationScope
import dev.libatorium.pushcompose.data.model.Message
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class IncomingMessageDataSourceImpl @Inject constructor(
    @ApplicationScope private val externalScope: CoroutineScope
) : IncomingMessageDataSource {

    override val messageFlow: StateFlow<Message> =
        MutableStateFlow(Message("Flow Starting Message"))

    override fun onNewMessage(message: Message) {
        externalScope.launch {
            (messageFlow as MutableStateFlow).emit(message)
        }
    }
}
