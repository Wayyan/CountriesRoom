package com.devduo.countriesroom.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devduo.countriesroom.base.helper.asyncviewstate.AsyncViewStateLiveData
import com.devduo.countriesroom.domain.model.CountryModel
import com.devduo.countriesroom.domain.usecase.FetchAllCountries
import com.devduo.countriesroom.domain.usecase.GetCountries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val fetchAllCountries: FetchAllCountries,
  private val getCountries: GetCountries
) : ViewModel() {
  val fetchAllCountriesLiveData = AsyncViewStateLiveData<List<CountryModel>>()
  val getCountriesLiveData = AsyncViewStateLiveData<List<CountryModel>>()

  fun fetchAllCountries() {
    fetchAllCountriesLiveData.postLoading()
    viewModelScope.launch {
      val result = kotlin.runCatching {
        fetchAllCountries.execute(Unit)
          .flowOn(Dispatchers.IO)
          .collect {
            fetchAllCountriesLiveData.postSuccess(it)
          }
      }

      result.exceptionOrNull()?.let {
        it.printStackTrace()
        fetchAllCountriesLiveData.postError(it, "Error Fetching Country List!")
      }
    }
  }

  fun getCountries() {
    getCountriesLiveData.postLoading()
    viewModelScope.launch {
      val result = kotlin.runCatching {
        getCountries.execute(Unit)
          .flowOn(Dispatchers.IO)
          .collect {
            getCountriesLiveData.postSuccess(it)
          }
      }

      result.exceptionOrNull()?.let {
        it.printStackTrace()
        getCountriesLiveData.postError(it, "Error Fetching Country List!")
      }
    }
  }
}