package com.example.newsapp.data.networks

import com.example.newsapp.app.Config
import com.example.newsapp.app.Endpoints
import com.example.newsapp.data.models.NewsResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NewsAPI {

    @GET(Endpoints.URL_EVERYTHING)
    fun getNewsItems(): Call<NewsResult>

    companion object {
        operator fun invoke(): NewsAPI {
            return Retrofit.Builder().baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsAPI::class.java)
        }
    }
}