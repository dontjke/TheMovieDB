package com.stepanov.themoviedb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.stepanov.themoviedb.R
import com.stepanov.themoviedb.databinding.FragmentMovieBinding
import com.stepanov.themoviedb.domain.Movie
import com.stepanov.themoviedb.utils.KEY_BUNDLE_MOVIE
import com.stepanov.themoviedb.view.adapter.MoviesRecyclerViewAdapter
import com.stepanov.themoviedb.view.adapter.OnItemClickListener
import com.stepanov.themoviedb.viewmodel.AppState
import com.stepanov.themoviedb.viewmodel.MoviesViewModel


class MoviesFragment : Fragment(), OnItemClickListener {

    private var _binding: FragmentMovieBinding? = null
    private val binding: FragmentMovieBinding
        get() {
            return _binding!!
        }
    private val adapter = MoviesRecyclerViewAdapter(this)
    private val moviesViewModel: MoviesViewModel by lazy {
        ViewModelProvider(this)[MoviesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.also {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 2)
        }
        val observer = { data: AppState -> renderData(data) }
        moviesViewModel.getData().observe(viewLifecycleOwner, observer)
        moviesViewModel.getMovie()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MoviesFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(id: Int) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(R.id.container, MovieDetailsFragment.newInstance(Bundle().apply {
                putInt(KEY_BUNDLE_MOVIE, id)
            }))
            .addToBackStack("")
            .commit()
    }

    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Error -> {
                Snackbar.make(binding.root, getString(R.string.error), Snackbar.LENGTH_LONG).show()
            }

            is AppState.Loading -> {
                Snackbar.make(binding.root, getString(R.string.loading), Snackbar.LENGTH_LONG)
                    .show()
            }

            is AppState.Success -> {
                adapter.setData(data.moviesList)
            }
        }
    }

}