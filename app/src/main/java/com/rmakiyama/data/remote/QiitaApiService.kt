package com.rmakiyama.data.remote

import com.rmakiyama.data.remote.response.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface QiitaApiService {

    @GET("tags/{tag_name}/items")
    suspend fun getTaggedArticles(
        @Path("tag_name") tagName: String = "android",
        @Query("page") page: Int
    ): List<ArticleResponse>

    companion object {

        const val ENDPOINT = "https://qiita.com/api/v2/"
    }
}
