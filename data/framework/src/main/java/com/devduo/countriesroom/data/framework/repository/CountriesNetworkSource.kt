package com.devduo.countriesroom.data.framework.repository

import com.devduo.countriesroom.domain.model.CountryModel

interface CountriesNetworkSource {
  fun getAllCountries():List<CountryModel>
}