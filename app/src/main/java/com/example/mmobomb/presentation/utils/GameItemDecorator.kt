package com.example.mmobomb.presentation.utils

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class GameItemDecorator(@DimenRes private val spaceDimen: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val itemPosition = parent.getChildLayoutPosition(view)
        if (itemPosition != 0) outRect.left = parent.context.resources.getDimension(spaceDimen).toInt()
    }
}