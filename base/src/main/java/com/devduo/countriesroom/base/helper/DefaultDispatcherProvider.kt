package com.devduo.countriesroom.base.helper

import com.devduo.countriesroom.domain.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DefaultDispatcherProvider @Inject constructor(): DispatcherProvider {
  override fun main(): CoroutineDispatcher {
    return Dispatchers.Main
  }

  override fun io(): CoroutineDispatcher {
    return Dispatchers.IO
  }

  override fun default(): CoroutineDispatcher {
    return Dispatchers.Default
  }

  override fun unconfined(): CoroutineDispatcher {
    return Dispatchers.Unconfined
  }
}