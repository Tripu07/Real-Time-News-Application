package com.example.application

import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import com.bumptech.glide.Glide

class detailed_news : AppCompatActivity() {
    lateinit var image_view2:ImageView
    lateinit var title2:TextView
    lateinit var description2:TextView
    lateinit var readmore:Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_news)
         var imageview2:ImageView=findViewById(R.id.image_view2)
        var title2:TextView=findViewById(R.id.title2)
        var description2:TextView=findViewById(R.id.description2)
        var readmore:Button=findViewById(R.id.read_more)

         val image1=intent.extras?.getString("image")
        val title1=intent.extras?.getString("title")
        val description1=intent.extras?.getString("description")
        val url1=intent.extras?.getString("url")

        Glide.with(this)
            .load(image1)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(image_view2)
        title2.text=title1
        description2.text=description1
readmore.setOnClickListener{

    val customTabsIntent = CustomTabsIntent.Builder().build()
    customTabsIntent.launchUrl(this, Uri.parse(url1))
}


}

    }
