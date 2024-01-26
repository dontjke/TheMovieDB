package com.stepanov.themoviedb.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.stepanov.themoviedb.databinding.FragmentMovieRecyclerItemBinding
import com.stepanov.themoviedb.domain.Movie

class MoviesRecyclerViewAdapter(
    private val onItemClickListener: OnItemClickListener,
    private var data: List<Movie> = listOf(),
//    private val imageLoader: ImageLoader<ImageView>
) : RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataNew: List<Movie>) {
        this.data = dataNew
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = FragmentMovieRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieHolder(binding.root)
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(data[position])
    }


    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            FragmentMovieRecyclerItemBinding.bind(itemView).apply {
                textViewRecyclerItem.text = movie.title
                imageViewRecyclerItem.load("https://image.tmdb.org/t/p/w500${movie.posterUrl}")
                root.setOnClickListener {
                    onItemClickListener.onItemClick(movie)
                }
            }
        }
    }
}