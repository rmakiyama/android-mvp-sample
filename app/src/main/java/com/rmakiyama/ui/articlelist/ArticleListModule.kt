package com.rmakiyama.ui.articlelist

import com.rmakiyama.ui.articlelist.ArticleListContract.Presenter
import dagger.Binds
import dagger.Module

@Module
abstract class ArticleListModule {

    @Binds
    abstract fun articleListPresenter(
        presenter: ArticleListPresenter
    ): Presenter
}
