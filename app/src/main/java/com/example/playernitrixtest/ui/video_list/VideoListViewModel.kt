package com.example.playernitrixtest.ui.video_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playernitrixtest.domain.usecase.GetVideoListUseCase
import com.example.playernitrixtest.domain.usecase.UpdateVideoCacheUseCase
import com.example.playernitrixtest.utils.getErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoListViewModel @Inject constructor(
    private val getVideoListUseCase: GetVideoListUseCase,
    private val updateVideoCacheUseCase: UpdateVideoCacheUseCase,
) : ViewModel() {

    val videoListAdapter = VideoListAdapter()

    init {
        fetchVideos()
        updateVideos()
    }

    private fun updateVideos() {
        viewModelScope.launch {
            updateVideoCacheUseCase.invoke()
                .catch {
                    it.getErrorMessage()
                }
        }
    }

    private fun fetchVideos() {
        viewModelScope.launch {
            getVideoListUseCase.invoke().collect { result ->
                result.fold(
                    onSuccess = { videos ->
                        videoListAdapter.submitList(videos)
                    },
                    onFailure = { error ->
                        error.getErrorMessage()
                    }
                )
            }
        }
    }
}