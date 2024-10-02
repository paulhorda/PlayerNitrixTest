package com.example.playernitrixtest.ui.video_list

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.playernitrixtest.databinding.ItemVideoBinding
import com.example.playernitrixtest.domain.model.Video

class VideoViewHolder(private val binding: ItemVideoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(video: Video, position: Int, elementCallback: ((Video, Int) -> Unit?)?) {
        binding.videoTitle.text = video.name
        Glide.with(binding.videoThumbnail.context).load(video.image).into(binding.videoThumbnail)

        binding.root.setOnClickListener { elementCallback?.invoke(video, position) }
    }
}