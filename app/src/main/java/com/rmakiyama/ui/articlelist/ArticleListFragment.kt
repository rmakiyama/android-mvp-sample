package com.rmakiyama.ui.articlelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.rmakiyama.R
import com.rmakiyama.databinding.FragmentArticleListBinding
import com.rmakiyama.di.Injectable
import com.rmakiyama.model.Article
import com.rmakiyama.ui.articlelist.item.ArticleItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import javax.inject.Inject

class ArticleListFragment :
    Fragment(R.layout.fragment_article_list),
    Injectable,
    ArticleListContract.View {

    @Inject
    override lateinit var presenter: ArticleListContract.Presenter
    private var _binding: FragmentArticleListBinding? = null
    private val binding get() = requireNotNull(_binding)
    private var _articleListAdapter: GroupAdapter<GroupieViewHolder>? = null
    private val articleListAdapter get() = requireNotNull(_articleListAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _articleListAdapter = GroupAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadArticles()

        _binding = FragmentArticleListBinding.bind(view)
        binding.listArticle.setup()
    }

    override fun onStart() {
        super.onStart()
        presenter.takeView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.dropView()
        _binding = null
        _articleListAdapter = null
    }

    override fun setLoading(active: Boolean) {
        if (active) binding.loading.show() else binding.loading.hide()
    }

    override fun showArticles(articles: List<Article>) {
        articleListAdapter.update(articles.map(::ArticleItem))
    }

    private fun RecyclerView.setup() {
        adapter = articleListAdapter
    }
}
