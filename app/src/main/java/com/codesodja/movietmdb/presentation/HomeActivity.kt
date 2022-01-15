package com.codesodja.movietmdb.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.codesodja.movietmdb.R
import com.codesodja.movietmdb.databinding.ActivityHomeBinding
import com.codesodja.movietmdb.presentation.artist.ArtistActivity
import com.codesodja.movietmdb.presentation.movie.MovieActivity
import com.codesodja.movietmdb.presentation.tv.TvActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        homeBinding.movieButton.setOnClickListener {
            val intent = Intent(this,  MovieActivity::class.java)
            startActivity(intent)
        }

        homeBinding.artistButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

        homeBinding.tvButton.setOnClickListener {
            val intent = Intent(this, TvActivity::class.java)
            startActivity(intent)
        }
    }
}