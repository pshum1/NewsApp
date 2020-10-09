package com.example.newsapp.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.data.models.Article
import com.example.newsapp.databinding.RowNewsAdapterBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_news_adapter.view.*

class AdapterNews(var list: ArrayList<Article>) :
    RecyclerView.Adapter<AdapterNews.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowNewsAdapterBinding.inflate(inflater)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var article = list[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(l: ArrayList<Article>) {
        list = l
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val rowNewsAdapterBinding: RowNewsAdapterBinding) : RecyclerView.ViewHolder(rowNewsAdapterBinding.root) {
        fun bind(article: Article) {
            rowNewsAdapterBinding.tvTitle.text = article.title
            rowNewsAdapterBinding.tvDescription.text = article.description
            //Log.d("abc", article.urlToImage)
            //var uriImg = Uri.parse(article.urlToImage)
            Picasso.get().load(article.urlToImage).placeholder(R.drawable.hourglass)
                .error(R.drawable.notfound).into(rowNewsAdapterBinding.imgViewCover)


            //GO TO THE LINK
//            itemView.setOnClickListener {
//                var uris = Uri.parse(article.url)
//                var intent = Intent(Intent.ACTION_VIEW, uris)
//                mContext.startActivity(intent)
//            }
        }

    }
}