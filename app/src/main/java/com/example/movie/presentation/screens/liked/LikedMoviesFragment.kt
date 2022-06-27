package com.example.movie.presentation.screens.liked

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.movie.databinding.FragmentLikedMoviesBinding
import com.example.movie.di.ViewModelFactory
import com.example.movie.presentation.adapters.PopulateAdapter
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LikedMoviesFragment : Fragment() {

    lateinit var binding: FragmentLikedMoviesBinding

    private val viewModel: LikedMoviesViewModel by viewModels { ViewModelFactory() }
    private var populateJob: Job? = null
    private lateinit var adapter: PopulateAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLikedMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PopulateAdapter()
        binding.likedRecycler.adapter = adapter
        populateJob?.cancel()
        populateJob = lifecycleScope.launch {
            viewModel.likedMoviesLiveData().observe(this@LikedMoviesFragment.viewLifecycleOwner) {
                adapter.submitData(lifecycle, it)
            }
        }
    }
}