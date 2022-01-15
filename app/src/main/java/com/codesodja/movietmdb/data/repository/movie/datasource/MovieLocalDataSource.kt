package com.codesodja.movietmdb.data.repository.movie.datasource

import com.codesodja.movietmdb.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()

}