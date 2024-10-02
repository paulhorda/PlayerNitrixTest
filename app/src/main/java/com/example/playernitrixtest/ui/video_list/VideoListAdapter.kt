package com.example.playernitrixtest.ui.video_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.playernitrixtest.databinding.ItemVideoBinding
import com.example.playernitrixtest.domain.model.Video

class VideoListAdapter : ListAdapter<Video, VideoViewHolder>(VideoDiffCallback()) {

    var elementCallback: ((Video, Int) -> Unit?)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemVideoBinding.inflate(layoutInflater, parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = getItem(position)
        holder.bind(video, position, elementCallback)
    }
}