package com.stepanov.themoviedb.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.stepanov.themoviedb.databinding.FragmentMovieDetailsBinding
import com.stepanov.themoviedb.domain.Movie
import com.stepanov.themoviedb.utils.IMAGE_START_URL
import com.stepanov.themoviedb.utils.KEY_BUNDLE_MOVIE

class MovieDetailsFragment : Fragment() {
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding: FragmentMovieDetailsBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderData()
    }

    private fun renderData() {
        with(binding){
            imageView.load(IMAGE_START_URL + getMovieFromBundle()?.posterUrl)
            titleTextView.text = getMovieFromBundle()?.title
            ratingTextView.text = getMovieFromBundle()?.rating.toString()
            overviewTextView.text = getMovieFromBundle()?.overview
        }
    }

    private fun getMovieFromBundle(): Movie? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(KEY_BUNDLE_MOVIE, Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelable(KEY_BUNDLE_MOVIE)
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