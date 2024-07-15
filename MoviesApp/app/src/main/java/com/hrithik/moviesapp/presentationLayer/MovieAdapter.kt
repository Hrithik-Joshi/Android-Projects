package com.hrithik.moviesapp.presentationLayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hrithik.moviesapp.R
import com.hrithik.moviesapp.databinding.ListItemBinding
import com.hrithik.moviesapp.dataLayer.model.Movie

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return movieList.size
    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.titleText.text = movie.title
            binding.descText.text = movie.overview
            val str = "Release: " + movie.releaseDate
            binding.releaseDate.text = str

            val posterURL = "https://image.tmdb.org/t/p/w500/" + movie.posterPath

            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }
}