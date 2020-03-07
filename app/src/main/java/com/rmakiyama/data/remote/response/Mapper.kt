package com.rmakiyama.data.remote.response

import com.rmakiyama.model.Article
import java.text.SimpleDateFormat
import java.util.Locale

fun ArticleResponse.toArticle(): Article {
    return Article(
        id = id,
        title = title,
        body = body,
        likeCount = likeCount,
        createdAt = SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ssX",
            Locale.JAPAN
        ).parse(createdAt),
        url = url
    )
}
