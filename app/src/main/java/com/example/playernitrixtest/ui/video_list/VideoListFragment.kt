package com.example.playernitrixtest.ui.video_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playernitrixtest.databinding.FragmentVideoListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoListFragment : Fragment() {
    private lateinit var binding: FragmentVideoListBinding
    private val viewModel: VideoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.videoListRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = viewModel.videoListAdapter
        }

        viewModel.videoListAdapter.elementCallback = { _, index ->
            val action =
                VideoListFragmentDirections.actionVideoListFragmentToVideoPlayerFragment(index)
            view.findNavController().navigate(action)
        }
    }
}