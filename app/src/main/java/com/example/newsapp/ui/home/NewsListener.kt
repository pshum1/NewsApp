package com.example.newsapp.ui.home

import androidx.lifecycle.LiveData
import com.example.newsapp.data.models.NewsResult

interface NewsListener {

    fun onStarted()
    fun onSuccess(response: LiveData<NewsResult>)
}