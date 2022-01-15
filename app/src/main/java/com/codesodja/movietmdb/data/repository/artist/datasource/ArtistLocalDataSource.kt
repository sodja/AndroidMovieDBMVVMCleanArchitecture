package com.codesodja.movietmdb.data.repository.artist.datasource

import com.codesodja.movietmdb.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}