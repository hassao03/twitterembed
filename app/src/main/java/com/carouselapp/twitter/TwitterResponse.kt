package com.carouselapp.twitter

data class TwitterResponse(
    val url: String,
    val author_name: String,
    val author_url: String,
    val html: String,
    val width: Int,
    val height: String?,
    val type: String,
    val cache_age: String,
    val provider_name: String,
    val provider_url: String,
    val version: String
)