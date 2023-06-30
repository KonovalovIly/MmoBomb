package com.example.mmobomb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.example.mmobomb.presentation.adapter.holder.ErrorViewHolder
import com.example.mmobomb.presentation.adapter.holder.ItemViewHolder
import com.example.mmobomb.presentation.adapter.holder.NotLoadedViewHolder
import com.example.mmobomb.presentation.adapter.holder.ProgressViewHolder

internal class CategoryLoadStateAdapter : LoadStateAdapter<ItemViewHolder>() {

    override fun getStateViewType(loadState: LoadState) = when (loadState) {
        is LoadState.NotLoading -> UNLOADED
        LoadState.Loading -> PROGRESS
        is LoadState.Error -> ERROR
    }

    override fun onBindViewHolder(holder: ItemViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ItemViewHolder {
        return when (loadState) {
            LoadState.Loading -> ProgressViewHolder(LayoutInflater.from(parent.context), parent)
            is LoadState.Error -> ErrorViewHolder(LayoutInflater.from(parent.context), parent)
            is LoadState.NotLoading -> NotLoadedViewHolder(LayoutInflater.from(parent.context), parent)
        }
    }

    private companion object {

        private const val UNLOADED = 2
        private const val ERROR = 1
        private const val PROGRESS = 0
    }
}