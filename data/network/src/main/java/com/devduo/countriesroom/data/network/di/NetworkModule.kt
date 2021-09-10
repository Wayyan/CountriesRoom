package com.devduo.countriesroom.data.network.di

import com.devduo.countriesroom.data.framework.repository.CountriesNetworkSource
import com.devduo.countriesroom.data.network.datasource.CountriesNetworkSourceImpl
import dagger.Binds
import dagger.Module

@Module(includes = [ApiServiceModule::class])
abstract class NetworkModule {
  //binds datasources below
  @Binds
  abstract fun countriesNetworkSource(countryNetworkSourceImpl: CountriesNetworkSourceImpl): CountriesNetworkSource
}