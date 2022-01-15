package com.codesodja.movietmdb.presentation.tv

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
import com.codesodja.movietmdb.R
import com.codesodja.movietmdb.databinding.ActivityTvBinding
import com.codesodja.movietmdb.presentation.di.Injector
import com.codesodja.movietmdb.presentation.movie.MovieViewModel
import com.codesodja.movietmdb.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvViewModel: TvViewModel
    private lateinit var tvBinding: ActivityTvBinding
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvBinding = DataBindingUtil.setContentView(this, R.layout.activity_tv)
        (application as Injector).createTvShowSubComponent().inject(this)

        tvViewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        initRecyclerViewAdapter()
        displayPopularTvShow()
    }

    private fun initRecyclerViewAdapter() {
        tvBinding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        tvShowAdapter = TvShowAdapter()
        tvBinding.tvShowRecyclerView.adapter = tvShowAdapter
    }

    private fun displayPopularTvShow() {
        showOrHideProgressBar(true)
        val responseLiveData = tvViewModel.getTvShows()
        responseLiveData.observe(this, Observer { tvShowList ->
            if (tvShowList != null) {
                tvShowAdapter.setList(tvShowList)
                tvShowAdapter.notifyDataSetChanged()
                showOrHideProgressBar(false)
            } else {
                showOrHideProgressBar(false)
                Toast.makeText(this, "tvShow is not available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showOrHideProgressBar(isShow: Boolean) {
        if (isShow) {
            tvBinding.tvShowProgressBar.visibility = View.VISIBLE
        } else {
            tvBinding.tvShowProgressBar.visibility = View.GONE
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
                updateTvShows()
                true
            }
            else-> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows(){
        showOrHideProgressBar(true)
        val response = tvViewModel.updateTvShow()
        response.observe(this, Observer { tvShowList->
            if (tvShowList != null){
                tvShowAdapter.setList(tvShowList)
                tvShowAdapter.notifyDataSetChanged()
                showOrHideProgressBar(false)
            } else {
                showOrHideProgressBar(false)
            }
        })
    }
}