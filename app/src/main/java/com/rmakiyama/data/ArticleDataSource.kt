package com.rmakiyama.data

import com.rmakiyama.model.Article

interface ArticleDataSource {

    suspend fun getArticles(
        page: Int
    ): List<Article>
}
