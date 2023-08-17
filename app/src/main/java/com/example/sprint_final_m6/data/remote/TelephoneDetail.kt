package com.example.sprint_final_m6.data.remote

data class TelephoneDetail(
    var id: Long,
    val name: String,
    val price: Int,
    val description: String,
    val lastPrice: Int,
    val credit: Boolean,
    val image: String
)
