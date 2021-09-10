package com.devduo.countriesroom.data.cache.datasource

import android.content.Context
import com.devduo.countriesroom.data.cache.room.CountriesDao
import com.devduo.countriesroom.data.cache.room.CountryEntity
import com.devduo.countriesroom.data.framework.repository.CountriesCacheSource
import com.devduo.countriesroom.domain.model.CountryModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CountriesCacheSourceImpl @Inject constructor(
  private val dao: CountriesDao,
  private val context: Context
) :
  CountriesCacheSource {
  private val sharedPreferences = context.getSharedPreferences("country", Context.MODE_PRIVATE)
  private val KEY_MARK_DONE = "isDone"
  override fun saveCountries(data: List<CountryModel>) {
    data.forEach {
      dao.insert(CountryEntity(name = it.name, capital = it.capital))
    }
    setMarkDone(true)
  }

  override fun getCountries(): Flow<List<CountryModel>> {
    return dao.getAllCountriesSortByNameDistinctUntilChanged().map { raw ->
      raw.map {
        it.mapToCountryModel()
      }
    }
  }

  override fun setMarkDone(b: Boolean) {
    sharedPreferences.edit().putBoolean(KEY_MARK_DONE, b).apply()
  }

  override fun isMarkDone(): Boolean {
    return sharedPreferences.getBoolean(KEY_MARK_DONE, false)
  }
}