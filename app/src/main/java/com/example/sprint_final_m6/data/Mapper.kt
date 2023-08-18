package com.example.sprint_final_m6.data

import com.example.sprint_final_m6.data.local.PhoneEntity
import com.example.sprint_final_m6.data.remote.Telephone

fun Telephone.convertToEntity(): PhoneEntity = PhoneEntity(this.id,this.name,this.price,this.image)