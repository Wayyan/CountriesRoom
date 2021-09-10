package com.devduo.countriesroom.data.network.datasource

import com.devduo.countriesroom.data.network.exceptions.NoContentException
import com.devduo.countriesroom.data.framework.repository.CountriesNetworkSource
import com.devduo.countriesroom.data.network.api.CountryApiServices
import com.devduo.countriesroom.data.network.extensions.executeOrThrow
import com.devduo.countriesroom.domain.model.CountryModel
import javax.inject.Inject

class CountriesNetworkSourceImpl @Inject constructor(private val apiServices: CountryApiServices) :
  CountriesNetworkSource {
  override fun getAllCountries(): List<CountryModel> {
    val rawResponse = apiServices.getCountryList().executeOrThrow()
    return if (rawResponse.isNullOrEmpty()) {
      throw NoContentException()
    } else {
      rawResponse.map {
        it.mapToCountryModel()
      }
    }
  }
}