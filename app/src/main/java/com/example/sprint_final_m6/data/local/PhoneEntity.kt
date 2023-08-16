package com.example.sprint_final_m6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_telefonos")
data class PhoneEntity( val phone:String){
    @PrimaryKey(autoGenerate = true) var id:Long = 0

}





