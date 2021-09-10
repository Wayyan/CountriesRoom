package com.devduo.countriesroom.data.network.di

import android.content.Context
import com.devduo.countriesroom.data.network.api.CountryApiServices
import com.devduo.countriesroom.domain.model.K
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object ApiServiceModule {
  private var retrofit: Retrofit?=null

  fun retrofit(context: Context): Retrofit {
    if (retrofit!=null)
      return retrofit!!

//        val moshi=Moshi.Builder()
//            .build()
//
//        val adapter = moshi.adapter(CountryResponse::class.java)

    return Retrofit.Builder().baseUrl(K.baseUrl)
      .addConverterFactory(MoshiConverterFactory.create())
      .client(OkHttpProvider.okHttpClient(context))
      .build()
  }

  @Provides
  fun countryApiService(context: Context): CountryApiServices {
    return retrofit(context).create(CountryApiServices::class.java)
  }
}