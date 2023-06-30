package com.example.mmobomb.presentation.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import com.example.mmobomb.databinding.ItemErrorBinding

class NotLoadedViewHolder internal constructor(
    private val binding: ItemErrorBinding
) : ItemViewHolder(binding.root) {

    override fun bind(loadState: LoadState) {
        require(loadState is LoadState.NotLoading)
        binding.root.text = loadState.toString()
    }

    companion object {

        operator fun invoke(
            layoutInflater: LayoutInflater,
            parent: ViewGroup? = null,
            attachToRoot: Boolean = false
        ): NotLoadedViewHolder = NotLoadedViewHolder(
            ItemErrorBinding.inflate(
                layoutInflater,
                parent,
                attachToRoot
            )
        )
    }
}