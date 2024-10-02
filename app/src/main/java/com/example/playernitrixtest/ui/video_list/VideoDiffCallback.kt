package com.example.playernitrixtest.ui.video_list

import androidx.recyclerview.widget.DiffUtil
import com.example.playernitrixtest.domain.model.Video

class VideoDiffCallback : DiffUtil.ItemCallback<Video>() {
    override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem == newItem
    }
}