package com.rmakiyama.ui.articlelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.rmakiyama.R
import com.rmakiyama.di.Injectable
import com.rmakiyama.model.Article
import timber.log.Timber
import javax.inject.Inject

class ArticleListFragment :
    Fragment(R.layout.fragment_article_list),
    Injectable,
    ArticleListContract.View {

    @Inject
    override lateinit var presenter: ArticleListContract.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadArticles()
    }

    override fun onStart() {
        super.onStart()
        presenter.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    override fun setLoading(active: Boolean) {
        Timber.i("info: active => $active")
    }

    override fun showArticles(articles: List<Article>) {
        articles.forEach { Timber.i("info: title => ${it.title}") }
    }
}
