package com.codesodja.movietmdb.data.repository.movie.datasource

import com.codesodja.movietmdb.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}