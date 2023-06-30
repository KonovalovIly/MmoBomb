package com.example.mmobomb.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.mmobomb.domain.model.GamesInfoWithCategory

class CategoryItemDiffCallback : DiffUtil.ItemCallback<GamesInfoWithCategory>() {

    override fun areItemsTheSame(oldItem: GamesInfoWithCategory, newItem: GamesInfoWithCategory): Boolean {
        return oldItem.category == newItem.category
    }

    override fun areContentsTheSame(oldItem: GamesInfoWithCategory, newItem: GamesInfoWithCategory): Boolean {
        return oldItem == newItem
    }
}