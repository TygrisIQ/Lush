package com.tygris.lush.di

import androidx.lifecycle.Lifecycle
import com.tygris.lush.ui.state.PlayerClient
import com.tygris.lush.ui.state.PlayerClientImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    internal abstract fun BindPlayerClient(impl: PlayerClientImpl): PlayerClient

//
//    companion object {
//        @Provides
//        fun providesApplicationLifecycle(): Lifecycle = ProcessLifecycleOwner.get().lifecycle
//    }


}