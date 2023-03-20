package dev.libatorium.pushcompose.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSource
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSourceImpl
import dev.libatorium.pushcompose.data.source.PushComposeFirebaseMessagingService

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModuleBindings {

    @Binds
    abstract fun bindIncomingMessageDataSource(
        incomingMessageDataSourceImpl: IncomingMessageDataSourceImpl
    ): IncomingMessageDataSource
}

@Module(includes = [DataModuleBindings::class])
@InstallIn(SingletonComponent::class)
object DataModuleProvisions {

    @Provides
    fun provideFirebaseMessagingService() = PushComposeFirebaseMessagingService()
}
