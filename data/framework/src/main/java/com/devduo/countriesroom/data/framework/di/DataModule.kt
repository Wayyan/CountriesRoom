package com.devduo.countriesroom.data.framework.di

import com.devduo.countriesroom.data.framework.repository.CountriesRepositoryImpl
import com.devduo.countriesroom.domain.repository.CountriesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
  //binds repository below
  @Binds
  abstract fun countriesRepository(countriesRepositoryImpl: CountriesRepositoryImpl): CountriesRepository
}