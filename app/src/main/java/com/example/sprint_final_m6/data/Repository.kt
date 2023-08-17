package com.example.sprint_final_m6.data

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sprint_final_m6.data.local.PhoneDao
import com.example.sprint_final_m6.data.local.PhoneEntity
import com.example.sprint_final_m6.data.remote.Telephone
import com.example.sprint_final_m6.data.remote.TelephoneApi

class Repository (private val telephoneApi: TelephoneApi, private val phoneDao: PhoneDao) {

    fun getPhonesEntity(): LiveData<List<PhoneEntity>> = phoneDao.getPhones()



    suspend fun loadPhones() {
        val response = telephoneApi.getData()
        if (response.isSuccessful){
            val resp = response.body()

            resp?.let{
                val phoneEntity = it.map{it.convert() }
                phoneDao.insertPhone(phoneEntity)


            }


        }else{
            Log.e("repositorio", response.errorBody().toString())
        }


    }

}
fun Telephone.convert(): PhoneEntity = PhoneEntity(this.id,this.name,this.price,this.image)