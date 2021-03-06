package com.example.movie.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.data.entity.MovieDto
import com.example.movie.databinding.AdapterMovieBinding
import com.example.movie.domain.entity.Movie

class PopulateAdapter :
    PagingDataAdapter<Movie, PopulateAdapter.MovieViewHolder>(MovieComparator) {

    class MovieViewHolder(val view: AdapterMovieBinding) : RecyclerView.ViewHolder(view.root)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)!!
        holder.view.nameMovie.text = movie.title
        holder.view.dateRelease.text = "Дата релиза: " + movie.release_date
        holder.view.popularityMovie.text = "Рейтинг: " + movie.vote_average.toString()
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w300" + movie.poster_path)
            .into(holder.view.imageMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    object MovieComparator : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}