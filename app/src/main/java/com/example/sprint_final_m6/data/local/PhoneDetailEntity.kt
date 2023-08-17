package com.example.sprint_final_m6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_detalle_telefonos")
data class PhoneDetailEntity (
    @PrimaryKey(autoGenerate = true) var id:Long,
    val name: String,
    val price: Int,
    val description: String,
    val lastPrice: Int,
    val credit: Boolean,
    val image: String,


    )
