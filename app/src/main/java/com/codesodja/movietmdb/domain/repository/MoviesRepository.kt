package com.codesodja.movietmdb.domain.repository

import com.codesodja.movietmdb.data.model.movie.Movie

interface MoviesRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}