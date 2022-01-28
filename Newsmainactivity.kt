package com.example.application





import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsMainActivity : AppCompatActivity() {
    lateinit var recycler_view:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newsapp)
        recycler_view = findViewById(R.id.recyler_view)
        getNews()

    }

    private fun getNews() {
        val news = Newsservice.newsInterface.Fetchnews("in", Constants.apikey, "technology")
        news.enqueue(object : retrofit2.Callback<NewsClass> {
            override fun onResponse(
                call: retrofit2.Call<NewsClass>,
                response: Response<NewsClass>
            ) {
                val newsResponse = response.body()



                newsResponse?.let {
                    recycler_view.adapter = NewsAdapter(it.articles, this@NewsMainActivity)
                }
                recycler_view.layoutManager = LinearLayoutManager(this@NewsMainActivity)
            }

            override fun onFailure(call: retrofit2.Call<NewsClass>, t: Throwable) {
                Log.e("MainActivity", t.message.toString())
            }

        })


    }
}
