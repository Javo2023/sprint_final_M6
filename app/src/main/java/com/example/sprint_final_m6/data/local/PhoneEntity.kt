package com.example.sprint_final_m6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_telefonos")
data class PhoneEntity(
    @PrimaryKey(autoGenerate = true) var id:Long,
    var name: String,
    var price: Int,
    var image: String


)

