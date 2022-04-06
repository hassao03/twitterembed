package com.carouselapp.twitter

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
class HttpClient {

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val api = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://publish.twitter.com/")
        .build()
        .create(Api::class.java)


    suspend fun getTweetPost(tweetId: String) = api
        .getTweetPost("https://twitter.com/twitter/status/$tweetId")
        .html
}