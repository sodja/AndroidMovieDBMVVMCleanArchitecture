package com.codesodja.movietmdb.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout.make
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
import com.codesodja.movietmdb.R
import com.codesodja.movietmdb.databinding.ActivityMovieBinding
import com.codesodja.movietmdb.presentation.di.Injector
import com.google.android.material.snackbar.Snackbar.make
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieBinding: ActivityMovieBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView(){
        initRecyclerViewAdapter()
        displayPopularMovies()
    }

    private fun initRecyclerViewAdapter() {
        movieBinding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter()
        movieBinding.movieRecyclerView.adapter = movieAdapter
    }

    private fun displayPopularMovies() {
        showOrHideProgressBar(true)
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {movieList->
            if (movieList!=null){
                movieAdapter.setList(movieList)
                movieAdapter.notifyDataSetChanged()
                showOrHideProgressBar(false)
            } else{
                showOrHideProgressBar(false)
                Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showOrHideProgressBar(isShow: Boolean) {
        if (isShow){
            movieBinding.movieProgressBar.visibility = View.VISIBLE
        } else {
            movieBinding.movieProgressBar.visibility = View.GONE
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
                updateMovies()
                true
            }
            else-> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        showOrHideProgressBar(true)
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer { movieList->
            if (movieList!=null){
                movieAdapter.setList(movieList)
                movieAdapter.notifyDataSetChanged()
                showOrHideProgressBar(false)
            }else{
                showOrHideProgressBar(false)
            }
        })
    }
}