package com.codesodja.movietmdb.data.api

import com.codesodja.movietmdb.data.model.artist.ArtistList
import com.codesodja.movietmdb.data.model.movie.MovieList
import com.codesodja.movietmdb.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDB {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey: String): Response<MovieList>
    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key")apiKey: String): Response<ArtistList>
    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apiKey: String): Response<TvShowList>
}