package com.devduo.countriesroom.data.cache.di

import com.devduo.countriesroom.data.cache.datasource.CountriesCacheSourceImpl
import com.devduo.countriesroom.data.framework.repository.CountriesCacheSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class CacheModule {
  //bind datasources below
  @Binds
  abstract fun countriesCacheSource(countriesCacheSourceImpl: CountriesCacheSourceImpl): CountriesCacheSource
}