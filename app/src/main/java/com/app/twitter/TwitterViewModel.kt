package com.app.twitter

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TwitterViewModel: ViewModel(){

    var tweetId: String = "507185938620219395" //other examples: 1511399609507196932

    private val httpClient = HttpClient()

    val twitterLiveData = MutableLiveData<String>()

    init {
        fetchTweetPost()
    }

    fun fetchTweetPost() {
        viewModelScope.launch(Dispatchers.IO){
            Log.d("@logs", tweetId)
            if(tweetId.isNotEmpty()) {
                val tweet = httpClient.getTweetPost(tweetId)
                twitterLiveData.postValue(tweet)
            }else{
                Log.d("@logs", "Text field is empty")
            }
        }
    }
}
