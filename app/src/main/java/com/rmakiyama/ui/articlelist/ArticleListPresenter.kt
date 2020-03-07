package com.rmakiyama.ui.articlelist

import com.rmakiyama.data.ArticleDataSource
import com.rmakiyama.di.FragmentScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@FragmentScope
class ArticleListPresenter @Inject constructor(
    private val articleDataSource: ArticleDataSource
) : ArticleListContract.Presenter {

    private var view: ArticleListContract.View? = null
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.Main

    private var page = 1

    override fun takeView(view: ArticleListContract.View) {
        this.view = view
    }

    override fun loadArticles() {
        launch {
            view?.setLoading(true)
            runCatching { articleDataSource.getArticles(page++) }
                .onSuccess { list -> view?.showArticles(list) }
                .onFailure(Timber::e)
            view?.setLoading(false)
        }
    }

    override fun dropView() {
        super.dropView()
        this.view = null
    }
}
