package dev.libatorium.pushcompose.data.source

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import dev.libatorium.pushcompose.data.model.Message
import javax.inject.Inject

@AndroidEntryPoint
class PushComposeFirebaseMessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var incomingMessageDataSource: IncomingMessageDataSource

    // You should always get the latest using the
    // FirebaseMessaging.getInstance().token future.
    var latestToken: String = ""
        private set

    init {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                latestToken = task.result
                Log.e("", latestToken)
            } else {
                Log.e("", "${task.exception}")
            }
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        latestToken = token
        Log.w("", "Token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val title = message.notification?.title ?: return
        val body = message.notification?.body ?: return

        incomingMessageDataSource.onNewMessage(Message(title = title, body = body))
    }
}
