package com.codesodja.movietmdb.domain.repository

import com.codesodja.movietmdb.data.model.artist.Artist

interface ArtistsRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}