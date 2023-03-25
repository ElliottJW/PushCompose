package dev.libatorium.pushcompose.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSource
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSourceImpl
import dev.libatorium.pushcompose.data.source.PushComposeFirebaseMessagingService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModuleBindings {

    @Binds
    @Singleton
    abstract fun bindIncomingMessageDataSource(
        incomingMessageDataSourceImpl: IncomingMessageDataSourceImpl
    ): IncomingMessageDataSource
}

@Module(includes = [DataModuleBindings::class])
@InstallIn(SingletonComponent::class)
object DataModuleProvisions {

    @Provides
    @Singleton
    fun provideFirebaseMessagingService() = PushComposeFirebaseMessagingService()
}
