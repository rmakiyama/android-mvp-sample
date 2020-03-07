package com.rmakiyama.data

import com.rmakiyama.data.remote.QiitaApiService
import com.rmakiyama.data.remote.response.ArticleResponse
import com.rmakiyama.data.remote.response.toArticle
import com.rmakiyama.model.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class ArticleRepository @Inject constructor(
    private val qiitaApi: QiitaApiService
) : ArticleDataSource {

    override suspend fun getArticles(
        page: Int
    ): List<Article> {
        return qiitaApi.getTaggedArticles(page = page)
            .map(ArticleResponse::toArticle)
    }
}
