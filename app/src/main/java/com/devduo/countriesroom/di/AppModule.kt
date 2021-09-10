package com.devduo.countriesroom.di

import android.app.Application
import android.content.Context
import com.devduo.countriesroom.data.cache.room.CountriesDao
import com.devduo.countriesroom.data.cache.room.CountriesRoomDatabase
import com.devduo.countriesroom.data.cache.room.CountriesRoomDatabase.Companion
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
  @Singleton
  @Provides
  fun context(application: Application): Context {
    return application.applicationContext
  }
}