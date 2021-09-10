package com.devduo.countriesroom.di

import android.content.Context
import com.devduo.countriesroom.adapter.CountryRecyclerAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AdapterModule {
  @Provides
  fun provideCountryRecyclerAdapter(@ApplicationContext context: Context) =
    CountryRecyclerAdapter(context)
}