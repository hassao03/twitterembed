package com.app.twitter

import retrofit2.http.GET
import retrofit2.http.Query

interface Api{

    @GET("oembed")
    suspend fun getTweetPost(@Query("url") url: String): TwitterResponse
}