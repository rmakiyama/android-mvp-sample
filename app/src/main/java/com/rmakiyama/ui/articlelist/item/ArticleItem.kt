package com.rmakiyama.ui.articlelist.item

import com.rmakiyama.R
import com.rmakiyama.databinding.ItemArticleBinding
import com.rmakiyama.model.Article
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

data class ArticleItem(
    private val article: Article
) : Item<GroupieViewHolder>() {

    override fun getLayout(): Int = R.layout.item_article

    override fun bind(
        viewHolder: GroupieViewHolder,
        position: Int
    ) {
        val binding = ItemArticleBinding.bind(viewHolder.root)
        binding.title.text = article.title
        binding.createdAt.text = article.createdAt.toString()
    }
}
