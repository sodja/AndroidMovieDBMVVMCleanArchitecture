package com.codesodja.movietmdb.data.repository.movie.datasourceImpl

import com.codesodja.movietmdb.data.api.MovieDB
import com.codesodja.movietmdb.data.model.movie.MovieList
import com.codesodja.movietmdb.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val movieDB: MovieDB,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList>  = movieDB.getPopularMovies(apiKey)
}