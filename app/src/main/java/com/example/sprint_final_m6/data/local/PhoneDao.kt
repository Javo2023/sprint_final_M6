package com.example.sprint_final_m6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhoneDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhone(phoneEntity: PhoneEntity)

    @Query("Select * from tabla_telefonos order by id asc")
    fun getPhones(): LiveData<List<PhoneEntity>>

}