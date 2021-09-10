package com.devduo.countriesroom.data.cache.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devduo.countriesroom.domain.model.Database
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
abstract class CountriesDao {
  @Query("SELECT * FROM ${Database.tableName} ORDER BY ${Database.nameField} ASC")
  abstract fun getAllCountriesSortByName(): Flow<List<CountryEntity>>

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  abstract fun insert(entity: CountryEntity)

  @Query("DELETE FROM ${Database.tableName}")
  abstract fun deleteAll()

  @ExperimentalCoroutinesApi
  fun getAllCountriesSortByNameDistinctUntilChanged() =
    getAllCountriesSortByName().distinctUntilChanged()
}