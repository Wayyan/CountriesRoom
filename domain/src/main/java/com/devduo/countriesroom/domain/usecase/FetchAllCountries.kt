package com.devduo.countriesroom.domain.usecase

import com.devduo.countriesroom.domain.CoroutineUseCase
import com.devduo.countriesroom.domain.DispatcherProvider
import com.devduo.countriesroom.domain.model.CountryModel
import com.devduo.countriesroom.domain.repository.CountriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAllCountries @Inject constructor(
  private val repository: CountriesRepository,
  dispatcherProvider: DispatcherProvider
) : CoroutineUseCase<Unit, Flow<List<CountryModel>>>(dispatcherProvider) {
  override fun provide(input: Unit): Flow<List<CountryModel>> {
    return repository.fetchCountries()
  }
}