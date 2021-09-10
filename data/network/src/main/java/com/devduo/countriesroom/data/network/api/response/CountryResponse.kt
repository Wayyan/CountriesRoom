package com.devduo.countriesroom.data.network.api.response

import com.devduo.countriesroom.domain.model.CountryModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryResponse(
  @Json(name = "name") val name: String,
  @Json(name = "capital") val capital: String
) {
  fun mapToCountryModel(): CountryModel {
    return CountryModel(
      name = name,
      capital = capital
    )
  }
}