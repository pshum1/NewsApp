package com.example.newsapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.data.models.Article
import com.example.newsapp.data.models.NewsResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsListener {

    var mList: ArrayList<Article> = ArrayList()
    var adapterNews: AdapterNews? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel.newsListener = this
        viewModel.getData()

        init()
    }

    private fun init() {
        adapterNews = AdapterNews(mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterNews
    }

    override fun onStarted() {

    }


    override fun onSuccess(response: LiveData<NewsResult>) {
        Log.d("newsResponse", "onSuccess Main")
        response.observe(this, { t ->
            mList = t.articles
            adapterNews?.setData(mList)

        })
        progress_bar.visibility = View.GONE
    }
}