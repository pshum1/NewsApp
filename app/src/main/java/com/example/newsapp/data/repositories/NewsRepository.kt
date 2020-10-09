package com.example.newsapp.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.models.NewsResult
import com.example.newsapp.data.networks.NewsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {

    fun getNewsItems(): MutableLiveData<NewsResult> {
        var newsAPI = NewsAPI()

        val newsResult = MutableLiveData<NewsResult>()

        newsAPI.getNewsItems().enqueue(object: Callback<NewsResult>{
            override fun onResponse(call: Call<NewsResult>, response: Response<NewsResult>) {

                if(response.isSuccessful){

                    newsResult.value = response.body()
                    Log.d("newsResponse", "onResponse: " + newsResult.value?.totalResults.toString())
                }
            }

            override fun onFailure(call: Call<NewsResult>, t: Throwable) {

            }

        })
        return newsResult

    }
}