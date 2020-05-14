package com.example.translate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.translate.recycler.ModelAdapter
import com.example.translate.viewmodel.TranslateViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ModelAdapter()

        recycler_view.adapter = adapter

        val viewModel = ViewModelProvider(this).get(TranslateViewModel::class.java)
        viewModel.wordTranslate.observe(this, Observer {
            adapter.changeWord(it)
            Glide.with(this).load(it.definitions!![0].image_url).into(word_image)
        })

        translate.setOnClickListener {
            viewModel.getDetails(word.text.toString(), this)
        }
    }
}
