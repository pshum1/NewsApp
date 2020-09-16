package com.example.newsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.newsapp.R
import com.example.newsapp.adapters.AdapterNews
import com.example.newsapp.models.Article
import com.example.newsapp.models.NewsResult
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mList: ArrayList<Article> = ArrayList()
    var adapterNews: AdapterNews? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        getData()
        adapterNews = AdapterNews(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterNews
    }

    private fun getData() {
        var url =
            "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=fa17f8caa65447a8b5369507869597d3"
        var requestQueue = Volley.newRequestQueue(this)

        var request = StringRequest(Request.Method.GET, url, {

            var gson = Gson()
            var newsResult = gson.fromJson(it, NewsResult::class.java)

            mList.addAll(newsResult.articles)
            adapterNews?.setData(mList)
            progress_bar.visibility = View.GONE

        }, {
            Log.d("abc", it.message)
        })
        requestQueue.add(request)
    }
}