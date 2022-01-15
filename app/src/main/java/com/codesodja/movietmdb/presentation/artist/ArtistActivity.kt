package com.codesodja.movietmdb.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codesodja.movietmdb.R
import com.codesodja.movietmdb.data.model.artist.Artist
import com.codesodja.movietmdb.databinding.ActivityArtistBinding
import com.codesodja.movietmdb.presentation.di.Injector
import com.codesodja.movietmdb.presentation.movie.MovieViewModel
import com.codesodja.movietmdb.presentation.movie.MovieViewModelFactory
import com.codesodja.movietmdb.presentation.tv.TvViewModel
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var artistBinding: ActivityArtistBinding
    private lateinit var artistAdapter: ArtistAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artistBinding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)

        artistViewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView(){
        initRecyclerViewAdapter()
        displayPopularArtist()
    }

    private fun initRecyclerViewAdapter() {
        artistBinding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        artistAdapter = ArtistAdapter()
        artistBinding.artistRecyclerView.adapter = artistAdapter
    }

    private fun displayPopularArtist() {
        showOrHideProgressBar(true)
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {artistList->
            if (artistList != null){
                artistAdapter.setList(artistList)
                artistAdapter.notifyDataSetChanged()
                showOrHideProgressBar(false)
            }
            else{
                showOrHideProgressBar(false)
                Toast.makeText(this, "artist list is not available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showOrHideProgressBar(isShow: Boolean) {
        if (isShow){
            artistBinding.artistProgressBar.visibility = View.VISIBLE
        } else {
            artistBinding.artistProgressBar.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update->{
                updateArtists()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists(){
        showOrHideProgressBar(true)
        val response = artistViewModel.updateArtist()
        response.observe(this, Observer { artistList->

            if (artistList!=null){
                artistAdapter.setList(artistList)
                artistAdapter.notifyDataSetChanged()
                showOrHideProgressBar(false)
            } else{
                showOrHideProgressBar(false)
            }
        })
    }
}