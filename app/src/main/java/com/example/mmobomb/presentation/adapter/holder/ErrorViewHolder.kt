package com.example.mmobomb.presentation.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import com.example.mmobomb.databinding.ItemErrorBinding

class ErrorViewHolder internal constructor(
    private val binding: ItemErrorBinding
) : ItemViewHolder(binding.root) {

    override fun bind(loadState: LoadState) {
        require(loadState is LoadState.Error)
        binding.root.text = loadState.error.localizedMessage
    }

    companion object {

        operator fun invoke(
            layoutInflater: LayoutInflater,
            parent: ViewGroup? = null,
            attachToRoot: Boolean = false
        ): ErrorViewHolder {
            return ErrorViewHolder(
                ItemErrorBinding.inflate(
                    layoutInflater,
                    parent,
                    attachToRoot
                )
            )
        }
    }
}