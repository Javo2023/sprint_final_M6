package com.example.sprint_final_m6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sprint_final_m6.data.remote.Telephone

@Entity(tableName = "tabla_telefonos")
data class PhoneEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val name: String,
    val price: Int,
    val image: String

    )








