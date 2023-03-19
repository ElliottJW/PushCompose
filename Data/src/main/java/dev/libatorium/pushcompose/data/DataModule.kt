package dev.libatorium.pushcompose.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSource
import dev.libatorium.pushcompose.data.source.IncomingMessageDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindIncomingMessageDataSource(
        incomingMessageDataSourceImpl: IncomingMessageDataSourceImpl
    ): IncomingMessageDataSource
}
