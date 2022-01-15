package com.codesodja.movietmdb.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codesodja.movietmdb.R
import com.codesodja.movietmdb.data.model.artist.Artist
import com.codesodja.movietmdb.databinding.ListItemBinding

class ArtistAdapter: RecyclerView.Adapter<ArtistViewHolder>() {
    private var artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listBinding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return ArtistViewHolder(listBinding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class ArtistViewHolder(private val listItemBinding: ListItemBinding): RecyclerView.ViewHolder(listItemBinding.root){

    fun bind(artist: Artist){
        listItemBinding.titleTextView.text = artist.name
        listItemBinding.descriptionTextView.text = artist.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500"+artist.profilePath
        Glide.with(listItemBinding.imageView.context).load(posterUrl).into(listItemBinding.imageView)
    }
}