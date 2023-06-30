package com.example.mmobomb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mmobomb.R.dimen
import com.example.mmobomb.databinding.CategoryItemBinding
import com.example.mmobomb.domain.model.GamesInfoWithCategory
import com.example.mmobomb.presentation.utils.CategoryItemDiffCallback
import com.example.mmobomb.presentation.utils.GameItemDecorator

class CategoryListAdapter(
    private val onGameClick: (Int) -> Unit,
    private val onSeeAllClick: (String) -> Unit
) : PagingDataAdapter<GamesInfoWithCategory, CategoryListAdapter.ViewHolder>(CategoryItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val gameListAdapter = GameListAdapter(onGameClick)
        private val itemDecoration = GameItemDecorator(dimen.size_normal_medium)

        fun bind(item: GamesInfoWithCategory) = with(binding) {
            gamesRecyclerView.adapter = gameListAdapter

            if (gamesRecyclerView.itemDecorationCount < 1) {
                gamesRecyclerView.addItemDecoration(itemDecoration)
            }

            gameListAdapter.submitList(item.games.take(10))
            category.text = item.category.replaceFirstChar { it.titlecaseChar() }
            seeAll.setOnClickListener {
                onSeeAllClick(item.category)
            }
        }
    }
}