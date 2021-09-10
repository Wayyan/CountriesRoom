package com.devduo.countriesroom.domain.repository

import com.devduo.countriesroom.domain.model.CountryModel
import kotlinx.coroutines.flow.Flow

interface CountriesRepository {
  fun fetchCountries(): Flow<List<CountryModel>>
  fun getCountries(): Flow<List<CountryModel>>
}