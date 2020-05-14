package com.example.translate.repository

import com.example.translate.model.Model
import com.example.translate.api.ApiService
import com.example.translate.api.RetrofitBuilder
import retrofit2.Call

object Repository {
    val repo: ApiService? by lazy {
        RetrofitBuilder.apiService
    }

    fun translate(word: String): Call<Model>? {
        return repo?.translate(word)
    }
}