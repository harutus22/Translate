package com.example.translate.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.translate.model.Model
import com.example.translate.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TranslateViewModel: ViewModel() {

    val wordTranslate: MutableLiveData<Model> = MutableLiveData()

    fun getDetails(word:String, context: Context){
            Repository.translate(word)?.enqueue(object : Callback<Model>{
                override fun onFailure(call: Call<Model>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Model>, response: Response<Model>) {
                    if (response.isSuccessful){
                        wordTranslate.value = response.body()
                    }
                }
            })
    }
}