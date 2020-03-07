package com.rmakiyama.data.remote.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleResponse(
    val id: String,
    val title: String,
    val body: String,
    @Json(name = "likes_count")
    val likeCount: Int,
    @Json(name = "created_at")
    val createdAt: String,
    val url: String
)
