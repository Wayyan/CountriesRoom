package com.devduo.countriesroom.data.cache.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devduo.countriesroom.domain.model.CountryModel
import com.devduo.countriesroom.domain.model.Database

@Entity(tableName = Database.tableName)
class CountryEntity(
  @PrimaryKey(autoGenerate = true) val id: Int? = null,
  @ColumnInfo(name = Database.nameField) val name: String,
  @ColumnInfo(name = Database.capitalField) val capital: String
) {
  fun mapToCountryModel(): CountryModel {
    return CountryModel(name, capital)
  }
}