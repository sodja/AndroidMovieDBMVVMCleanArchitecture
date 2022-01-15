package com.codesodja.movietmdb.data.repository.artist.datasource

import com.codesodja.movietmdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>
}