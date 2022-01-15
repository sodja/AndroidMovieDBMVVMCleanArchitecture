package com.codesodja.movietmdb.data.repository.movie.datasource

import com.codesodja.movietmdb.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}