package com.example.playernitrixtest.ui.video_player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playernitrixtest.domain.model.Video
import com.example.playernitrixtest.domain.usecase.GetVideoListUseCase
import com.example.playernitrixtest.utils.getErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoPlayerVideModel @Inject constructor(
    private val getVideoListUseCase: GetVideoListUseCase,
) : ViewModel() {

    private val _videoList: MutableLiveData<List<Video>> = MutableLiveData()
    val videoList: LiveData<List<Video>> get() = _videoList

    init {
        fetchVideos()
    }

    private fun fetchVideos() {
        viewModelScope.launch {
            getVideoListUseCase.invoke().collect { result ->
                result.fold(
                    onSuccess = { videos ->
                        _videoList.value = videos
                    },
                    onFailure = { error ->
                        error.getErrorMessage()
                    }
                )
            }
        }
    }
}