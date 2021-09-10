package com.devduo.countriesroom.base.di

import com.devduo.countriesroom.base.helper.DefaultDispatcherProvider
import com.devduo.countriesroom.data.cache.di.CacheModule
import com.devduo.countriesroom.data.framework.di.DataModule
import com.devduo.countriesroom.data.network.di.NetworkModule
import com.devduo.countriesroom.domain.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule::class, NetworkModule::class])
abstract class BaseAppModule {
  @Binds
  abstract fun dispatcherProvider(defaultDispatcherProvider: DefaultDispatcherProvider): DispatcherProvider
}