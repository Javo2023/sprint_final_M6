package com.example.sprint_final_m6.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TelephoneApi {
    @GET("products/")
    suspend fun getData(): Response<List<Telephone>>

    @GET("details/{id}")
    suspend fun getDetailPhone(@Path("id") id:String): Response<TelephoneDetail>


}
