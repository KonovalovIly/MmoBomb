package com.example.mmobomb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mmobomb.databinding.GameItemBinding
import com.example.mmobomb.domain.model.GameBaseInfo
import com.example.mmobomb.presentation.utils.GameItemDiffCallback

class GameListAdapter(private val onGameClick: (Int) -> Unit) :
    ListAdapter<GameBaseInfo, GameListAdapter.ViewHolder>(GameItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        GameItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: GameItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GameBaseInfo) = with(binding) {
            gameImage.load(item.thumbnail)
            gameName.text = item.title

            cardView.setOnClickListener {
                onGameClick(item.id)
            }
        }
    }
}