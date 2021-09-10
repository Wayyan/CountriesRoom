package com.devduo.countriesroom.data.network.api

import com.devduo.countriesroom.data.network.api.response.CountryResponse
import retrofit2.Call
import retrofit2.http.GET

interface CountryApiServices {
  @GET("all")
  fun getCountryList(): Call<List<CountryResponse>>
}