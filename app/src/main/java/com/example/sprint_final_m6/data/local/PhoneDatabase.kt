package com.example.sprint_final_m6.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PhoneEntity::class],version = 1)
abstract class PhoneDatabase: RoomDatabase(){

    abstract fun getPhonesDao(): PhoneDao

    companion object {
        @Volatile
        private var INSTANCE: PhoneDatabase? = null

        fun getDataBase (context: Context): PhoneDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhoneDatabase::class.java,
                    "razas_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}