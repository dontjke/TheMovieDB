package com.stepanov.themoviedb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.google.android.material.snackbar.Snackbar
import com.stepanov.themoviedb.R
import com.stepanov.themoviedb.databinding.FragmentMovieDetailsBinding
import com.stepanov.themoviedb.utils.IMAGE_START_URL
import com.stepanov.themoviedb.utils.KEY_BUNDLE_MOVIE
import com.stepanov.themoviedb.viewmodel.MovieDetails
import com.stepanov.themoviedb.viewmodel.MovieDetailsViewModel

class MovieDetailsFragment : Fragment() {
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding: FragmentMovieDetailsBinding
        get() {
            return _binding!!
        }
    private val movieDetailsViewModel: MovieDetailsViewModel by lazy {
        ViewModelProvider(this)[MovieDetailsViewModel::class.java]
    }
    private var movieIdBundle: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieIdBundle = requireArguments().getInt(KEY_BUNDLE_MOVIE)

        val observer = { data: MovieDetails -> renderData(data) }
        movieDetailsViewModel.getData().observe(viewLifecycleOwner, observer)
        movieDetailsViewModel.getMovie(movieIdBundle)
    }

    private fun renderData(data: MovieDetails) {
        when (data) {
            is MovieDetails.Error -> {
                Snackbar.make(binding.root, getString(R.string.error), Snackbar.LENGTH_LONG).show()
            }
            is MovieDetails.Loading -> {
                Snackbar.make(binding.root, getString(R.string.loading), Snackbar.LENGTH_SHORT)
                    .show()
            }
            is MovieDetails.Success -> {
                with(binding) {
                    imageView.load(IMAGE_START_URL + data.movie.posterUrl)
                    titleTextView.text = data.movie.title
                    ratingTextView.text = data.movie.rating.toString()
                    overviewTextView.text = data.movie.overview
                }
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) =
            MovieDetailsFragment().apply {
                arguments = bundle
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}