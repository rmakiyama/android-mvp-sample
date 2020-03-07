package com.rmakiyama.ui

import com.rmakiyama.di.FragmentScope
import com.rmakiyama.ui.articlelist.ArticleListFragment
import com.rmakiyama.ui.articlelist.ArticleListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [ArticleListModule::class])
    internal abstract fun contributeArticleListFragment(): ArticleListFragment
}
