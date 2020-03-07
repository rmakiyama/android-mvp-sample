package com.rmakiyama.ui.articlelist

import com.rmakiyama.BasePresenter
import com.rmakiyama.BaseView
import com.rmakiyama.model.Article

interface ArticleListContract {

    interface View : BaseView<Presenter> {

        fun setLoading(active: Boolean)

        fun showArticles(articles: List<Article>)
    }

    interface Presenter : BasePresenter<View> {

        fun loadArticles()
    }
}
