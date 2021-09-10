package com.devduo.countriesroom.data.framework.repository

import com.devduo.countriesroom.domain.model.CountryModel
import kotlinx.coroutines.flow.Flow

interface CountriesCacheSource {
  fun saveCountries(data:List<CountryModel>)
  fun getCountries():Flow<List<CountryModel>>
  fun setMarkDone(b:Boolean)
  fun isMarkDone():Boolean
}