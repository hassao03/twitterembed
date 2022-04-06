package com.carouselapp.twitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel = TwitterViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButton()
        observeTweetPost()
    }

    private fun observeTweetPost() {
        viewModel.twitterLiveData.observe(this){ tweet ->
            webview.settings.domStorageEnabled = true
            webview.settings.javaScriptEnabled = true
            webview.loadDataWithBaseURL("https://twitter.com", tweet, "text/html", "UTF-8", null)
        }
    }

    private fun setButton() {
        val button = findViewById<Button>(R.id.showTweet)
        button.setOnClickListener{
            viewModel.tweetId = tweetId.text.toString()
            viewModel.fetchTweetPost()
        }
    }
}