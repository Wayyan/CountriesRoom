package com.devduo.countriesroom.data.cache.di

import android.content.Context
import com.devduo.countriesroom.data.cache.room.CountriesDao
import com.devduo.countriesroom.data.cache.room.CountriesRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
  @Provides
  fun provideChannelDao(database:CountriesRoomDatabase):CountriesDao{
    return database.countriesDao()
  }

  @Provides
  @Singleton
  fun provideDatabase(@ApplicationContext context: Context): CountriesRoomDatabase {
    return CountriesRoomDatabase.getDatabase(context)
  }
}