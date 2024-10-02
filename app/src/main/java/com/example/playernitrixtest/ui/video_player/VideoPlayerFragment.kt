package com.example.playernitrixtest.ui.video_player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.fragment.navArgs
import com.example.playernitrixtest.R
import com.example.playernitrixtest.databinding.FragmentVideoPlayerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class VideoPlayerFragment : Fragment() {
    private lateinit var binding: FragmentVideoPlayerBinding
    private val args: VideoPlayerFragmentArgs by navArgs()
    private var player: ExoPlayer? = null
    private val videModel: VideoPlayerVideModel by viewModels()
    private var currentVideoIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentVideoIndex = args.index

        binding.playPauseButton.setOnClickListener {
            if (player?.isPlaying == true) {
                player?.pause()
                binding.playPauseButton.text = getString(R.string.start)
            } else {
                player?.play()
                binding.playPauseButton.text = getString(R.string.stop)
            }
        }

        binding.nextButton.setOnClickListener {
            if (currentVideoIndex > 0) {
                currentVideoIndex--
                playVideoAtIndex(currentVideoIndex)
            }
        }

        binding.previousButton.setOnClickListener {
            if (currentVideoIndex < (videModel.videoList.value?.size?.minus(1) ?: 0)) {
                currentVideoIndex++
                playVideoAtIndex(currentVideoIndex)
            }
        }
        binding.videoProgressBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    player?.seekTo((progress * 1000).toLong())
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        player = ExoPlayer.Builder(requireContext()).build()
        binding.playerView.player = player
        updateProgressBar()
        videModel.videoList.observe(viewLifecycleOwner) { list ->
            val mediaItems = list.map {
                MediaItem.fromUri(it.link)
            }
            player?.setMediaItems(mediaItems)
            initializePlayer()
        }

        player?.prepare()
        player?.playWhenReady = true
    }

    private fun initializePlayer() {
        playVideoAtIndex(args.index)
    }

    private fun playVideoAtIndex(index: Int) {
        player?.seekTo(index, C.TIME_UNSET)
        player?.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                if (playbackState == Player.STATE_READY) {
                    binding.videoProgressBar.max = (player?.duration?.div(1000) ?: 0).toInt()
                }
            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                if (isPlaying) {
                    updateProgressBar()
                }
            }
        })
    }

    private fun updateProgressBar() {
        lifecycleScope.launch(Dispatchers.Main) {
            while (player?.isPlaying == true) {
                val currentPosition = player?.currentPosition ?: 0L

                withContext(Dispatchers.Main) {
                    binding.videoProgressBar.progress = currentPosition.toInt() / 1000
                }
                delay(1000)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        if (player != null) {
            player?.release()
            player = null
        }
    }
}