package dev.libatorium.pushcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.libatorium.pushcompose.data.source.PushComposeFirebaseMessagingService
import dev.libatorium.pushcompose.ui.HomeScreenContent
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var pushComposeFirebaseMessagingService: PushComposeFirebaseMessagingService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreenContent(homeViewModel = viewModel)
        }
    }
}
