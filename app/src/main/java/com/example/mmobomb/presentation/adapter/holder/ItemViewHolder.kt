package com.example.mmobomb.presentation.adapter.holder

import android.view.View
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView

abstract class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(loadState: LoadState)
}