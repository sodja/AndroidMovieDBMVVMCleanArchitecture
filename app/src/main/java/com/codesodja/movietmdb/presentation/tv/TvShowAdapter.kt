package com.codesodja.movietmdb.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codesodja.movietmdb.R
import com.codesodja.movietmdb.data.model.tvshow.TvShow
import com.codesodja.movietmdb.databinding.ListItemBinding

class TvShowAdapter: RecyclerView.Adapter<TvShowViewHolder>() {
    private var tvShowList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listBinding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return TvShowViewHolder(listBinding)

    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class TvShowViewHolder(private val listBinding: ListItemBinding): RecyclerView.ViewHolder(listBinding.root){

    fun bind(tvShow: TvShow){
        listBinding.titleTextView.text = tvShow.name
        listBinding.descriptionTextView.text = tvShow.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(listBinding.imageView.context).load(posterUrl).into(listBinding.imageView)
    }
}