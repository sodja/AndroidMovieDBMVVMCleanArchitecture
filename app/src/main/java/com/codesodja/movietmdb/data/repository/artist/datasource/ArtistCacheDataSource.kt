package com.codesodja.movietmdb.data.repository.artist.datasource

import com.codesodja.movietmdb.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}