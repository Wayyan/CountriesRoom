package com.devduo.countriesroom.data.cache.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CountryEntity::class], version = 1, exportSchema = false)
public abstract class CountriesRoomDatabase : RoomDatabase() {
  abstract fun countriesDao(): CountriesDao

  companion object {
    @Volatile
    private var INSTANCE: CountriesRoomDatabase? = null
    fun getDatabase(context: Context): CountriesRoomDatabase {
      return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          CountriesRoomDatabase::class.java,
          "word_database"
        ).build()
        INSTANCE = instance
        instance
      }
    }
  }
}