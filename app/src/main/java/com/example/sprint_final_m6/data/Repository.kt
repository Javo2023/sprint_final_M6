package com.example.sprint_final_m6.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sprint_final_m6.data.local.PhoneDao
import com.example.sprint_final_m6.data.local.PhoneDetailEntity
import com.example.sprint_final_m6.data.local.PhoneEntity
import com.example.sprint_final_m6.data.remote.Telephone
import com.example.sprint_final_m6.data.remote.TelephoneApi
import com.example.sprint_final_m6.data.remote.TelephoneDetail

class Repository (private val telephoneApi: TelephoneApi, private val phoneDao: PhoneDao) {

    fun getPhonesEntity(): LiveData<List<PhoneEntity>> = phoneDao.getPhones()
    fun getDetailEntity(id:String):LiveData<PhoneDetailEntity> = phoneDao.getDetailPhone(id)



    suspend fun loadPhones() {
        val response = telephoneApi.getData()
        if (response.isSuccessful){
            val resp = response.body()

            resp?.let{
                val phoneEntity = it.map{it.convertToEntity() }
                phoneDao.insertPhone(phoneEntity)

            }
        }else{
            Log.e("repositorio", response.errorBody().toString())
        }


    }
    suspend fun getDetailPhone(id:String){
        val response = telephoneApi.getDetailPhone(id)
        if(response.isSuccessful){
            val detailResponse = response.body()
            detailResponse?.let{
                val phoneDetailEntity = it.convertDetailToEntity()
                phoneDao.insertDetailPhone(phoneDetailEntity)
            }

        }
    }

}





fun TelephoneDetail.convertDetailToEntity(): PhoneDetailEntity = PhoneDetailEntity(this.id,this.name,this.price,this.description,this.lastPrice,this.credit,this.image)