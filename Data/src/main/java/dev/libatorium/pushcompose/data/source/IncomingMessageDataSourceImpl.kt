package dev.libatorium.pushcompose.data.source

import dev.libatorium.pushcompose.common.ApplicationScope
import dev.libatorium.pushcompose.data.model.Message
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class IncomingMessageDataSourceImpl @Inject constructor(
    @ApplicationScope private val externalScope: CoroutineScope
) : IncomingMessageDataSource {

    private val _messageFlow = MutableSharedFlow<Message>(replay = 0)
    override val messageFlow: SharedFlow<Message> = _messageFlow

//    // This _does_ push values to the HomeRepository
//    init {
//        externalScope.launch {
//            var num = 0
//            while (true) {
//                _messageFlow.emit(Message("Message $num"))
//                num++
//                delay(1000L)
//            }
//        }
//    }

    // This _does not_ push values to the home repository.
    override fun onNewMessage(message: Message) {
        externalScope.launch {
            _messageFlow.emit(message)
        }
    }
}
