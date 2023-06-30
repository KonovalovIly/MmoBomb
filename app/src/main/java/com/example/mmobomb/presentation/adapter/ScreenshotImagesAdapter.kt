package com.example.mmobomb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mmobomb.databinding.ItemScreenshotBinding
import com.example.mmobomb.presentation.adapter.ScreenshotImagesAdapter.ViewHolder

internal class ScreenshotImagesAdapter(private val screenshots: List<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemScreenshotBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = screenshots.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(screenshots[position])
    }

    inner class ViewHolder(private val binding: ItemScreenshotBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.screenshot.load(item)
        }
    }
}