package com.example.mmobomb.presentation.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import com.example.mmobomb.databinding.ItemProgressBinding

class ProgressViewHolder internal constructor(binding: ItemProgressBinding) : ItemViewHolder(binding.root) {

    override fun bind(loadState: LoadState) {}

    companion object {

        operator fun invoke(
            layoutInflater: LayoutInflater,
            parent: ViewGroup? = null,
            attachToRoot: Boolean = false
        ): ProgressViewHolder {
            return ProgressViewHolder(
                ItemProgressBinding.inflate(
                    layoutInflater,
                    parent,
                    attachToRoot
                )
            )
        }
    }
}