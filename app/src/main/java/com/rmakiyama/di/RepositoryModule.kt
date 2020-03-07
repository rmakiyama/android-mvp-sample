package com.rmakiyama.di

import com.rmakiyama.data.ArticleDataSource
import com.rmakiyama.data.ArticleRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {

    @Binds
    fun bindArticleRepository(repository: ArticleRepository): ArticleDataSource
}
