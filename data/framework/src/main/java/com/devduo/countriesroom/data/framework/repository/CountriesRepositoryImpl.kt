package com.devduo.countriesroom.data.framework.repository

import com.devduo.countriesroom.domain.model.CountryModel
import com.devduo.countriesroom.domain.repository.CountriesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
  private val networkSource: CountriesNetworkSource,
  private val cacheSource: CountriesCacheSource
) :
  CountriesRepository {
  override fun fetchCountries(): Flow<List<CountryModel>> {
    return flow {
      if (!cacheSource.isMarkDone()) {
        val data = networkSource.getAllCountries()
        emit(data)
        cacheSource.saveCountries(data)
      } else {
        emit(emptyList<CountryModel>())
      }
    }
  }

  override fun getCountries(): Flow<List<CountryModel>> {
    return cacheSource.getCountries()
  }
}