package com.devduo.countriesroom.feature

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.devduo.countriesroom.R
import com.devduo.countriesroom.R.layout
import com.devduo.countriesroom.adapter.CountryRecyclerAdapter
import com.devduo.countriesroom.base.base.BaseActivity
import com.devduo.countriesroom.base.helper.asyncviewstate.AsyncViewState
import com.devduo.countriesroom.databinding.ActivityMainBinding
import com.devduo.countriesroom.extension.getLoadingDialog
import com.devduo.countriesroom.extension.showShortToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
  override val binding: ActivityMainBinding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
  }

  @Inject lateinit var countryAdapter: CountryRecyclerAdapter
  private val viewModel: MainViewModel by viewModels()

  private lateinit var loadingDialog: Dialog

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initUi()
    initListener()
  }

  private fun initUi() {
    loadingDialog = this.getLoadingDialog(resources.getString(R.string.lbl_loading))
    initRecycler()
    viewModel.getCountries()
    viewModel.fetchAllCountries()
  }

  private fun initRecycler() {
    binding.recyclerCountry.apply {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(applicationContext)
      adapter = countryAdapter
    }
  }

  private fun initListener() {
    viewModel.fetchAllCountriesLiveData.observe(this, {
      when (it) {
        is AsyncViewState.Loading -> {
          loadingDialog.show()
        }

        is AsyncViewState.Error -> {
          loadingDialog.dismiss()
        }

        is AsyncViewState.Success -> {
          loadingDialog.dismiss()
          if (it.value.isNotEmpty()) {
            this.showShortToast("Found ${it.value.size} countries!")
          }
        }

      }
    })

    viewModel.getCountriesLiveData.observe(this, {
      when (it) {
        is AsyncViewState.Loading -> {
        }

        is AsyncViewState.Error -> {
        }

        is AsyncViewState.Success -> {
          countryAdapter.setNewData(it.value)
        }

      }
    })
  }
}