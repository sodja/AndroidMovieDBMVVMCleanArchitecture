package com.codesodja.movietmdb.data.repository.artist.datasourceImpl

import com.codesodja.movietmdb.data.api.MovieDB
import com.codesodja.movietmdb.data.model.artist.ArtistList
import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val movieDB: MovieDB,
    private val apiKey: String
    ): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = movieDB.getPopularArtists(apiKey)
}