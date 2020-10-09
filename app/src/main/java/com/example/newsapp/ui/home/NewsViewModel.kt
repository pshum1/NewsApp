package com.example.newsapp.ui.home

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.models.NewsResult
import com.example.newsapp.data.repositories.NewsRepository

class NewsViewModel: ViewModel() {

    var title: String? = null
    var description: String? = null

    var newsListener: NewsListener? = null

    fun getData(){
        newsListener?.onStarted()

        Log.d("newsResponse", "Getdata")
        val newsResponse: MutableLiveData<NewsResult> = NewsRepository().getNewsItems()

//        if(registerResponse.value?.status == "ok"){
//            Log.d("newsResponse","ok")
//            newsListener?.onSuccess(registerResponse)
//        }
        Log.d("newsResponse", "count " + newsResponse.value?.totalResults.toString())
        newsListener?.onSuccess(newsResponse)
    }

    fun onNewsItemClicked(view: View){

    }
}