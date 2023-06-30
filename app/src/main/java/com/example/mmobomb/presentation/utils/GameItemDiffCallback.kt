package com.example.mmobomb.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.mmobomb.domain.model.GameBaseInfo

class GameItemDiffCallback : DiffUtil.ItemCallback<GameBaseInfo>() {

    override fun areItemsTheSame(oldItem: GameBaseInfo, newItem: GameBaseInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GameBaseInfo, newItem: GameBaseInfo): Boolean {
        return oldItem == newItem
    }
}