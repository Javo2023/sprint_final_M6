package com.example.sprint_final_m6.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface TelephoneApi {
    @GET("Himuravidal/FakeAPIdata/products/")
    suspend fun getData(): Response<List<Telephone>>


}