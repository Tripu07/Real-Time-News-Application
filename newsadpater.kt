package com.example.application

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter (private val list:List<Article>,private val context: Context ):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val newsImage: ImageView = itemView.findViewById(R.id.image_view)
        val titleText: TextView = itemView.findViewById(R.id.title)
        val descText:TextView = itemView.findViewById(R.id.description)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.newsdesign, parent, false)
        return NewsViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        holder.titleText.text = list[position].title
        holder.descText.text = list[position].description

        Glide.with(context)
            .load(list[position].urltoImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.newsImage)

        val currentItem = list[position]

        holder.itemView.setOnClickListener{
            val viewintent =Intent(context,detailed_news::class.java)
            viewintent.putExtra("image",currentItem.urltoImage)
            viewintent.putExtra("title",currentItem.title)
            viewintent.putExtra("description",currentItem.description)
            viewintent.putExtra("url",currentItem.url)
                context.startActivity(viewintent)
        }

    }

