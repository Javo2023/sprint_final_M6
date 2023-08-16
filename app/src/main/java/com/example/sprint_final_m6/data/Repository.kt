package com.example.sprint_final_m6.data

import com.example.sprint_final_m6.data.local.PhoneDao
import com.example.sprint_final_m6.data.local.PhoneEntity
import com.example.sprint_final_m6.data.remote.Telephone
import com.example.sprint_final_m6.data.remote.TelephoneApi

class Repository (private val telephoneApi: TelephoneApi, private val phoneDao: PhoneDao) {

    suspend fun loadPhones(): List<Telephone>{
        val response = telephoneApi.getData()
        if (response.isSuccessful){
            val resp = response.body()
            resp?.let{
                return it
            }
        }
        return emptyList()

    }


}