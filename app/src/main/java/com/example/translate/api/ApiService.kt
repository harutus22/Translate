package com.example.translate.api

import com.example.translate.constants.API_KEY
import com.example.translate.model.Model
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Headers("Authorization: Token $API_KEY")
    @GET("{word}")
    fun translate(@Path("word") word: String): Call<Model>
}