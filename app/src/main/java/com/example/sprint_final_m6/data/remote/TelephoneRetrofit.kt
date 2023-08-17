package com.example.sprint_final_m6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TelephoneRetrofit {
    companion object {
        private const val URL_BASE = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"
        fun getRetrofitTelephone(): TelephoneApi {

            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(TelephoneApi::class.java)

        }
    }
}