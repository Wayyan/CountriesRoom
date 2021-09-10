package com.devduo.countriesroom.adapter

import android.content.Context
import android.view.ViewGroup
import com.devduo.countriesroom.adapter.CountryRecyclerAdapter.CountryViewHolder
import com.devduo.countriesroom.base.base.BaseRecyclerAdapter
import com.devduo.countriesroom.base.base.BaseRecyclerViewHolder
import com.devduo.countriesroom.databinding.ItemCountryBinding
import com.devduo.countriesroom.domain.model.CountryModel
import javax.inject.Inject

class CountryRecyclerAdapter @Inject constructor(private val context: Context) :
  BaseRecyclerAdapter<CountryViewHolder, CountryModel>(context) {
  inner class CountryViewHolder(private val binding: ItemCountryBinding) :
    BaseRecyclerViewHolder<CountryModel>(binding.root) {
    override fun bind(model: CountryModel) {
      binding.tvCountryName.text = model.name
      binding.tvCapitalName.text = model.capital
    }
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): CountryViewHolder {
    val binding = ItemCountryBinding.inflate(mLayoutInflater, parent, false)
    return CountryViewHolder(binding)
  }

  override fun onBindViewHolder(
    holder: CountryViewHolder,
    position: Int
  ) {
    holder.bind(mData[position])
  }
}