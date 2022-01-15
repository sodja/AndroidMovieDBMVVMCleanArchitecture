package com.codesodja.movietmdb.domain.usecase.artist

import com.codesodja.movietmdb.data.model.artist.Artist
import com.codesodja.movietmdb.domain.repository.ArtistsRepository

class UpdateArtistUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute(): List<Artist>? = artistsRepository.updateArtists()
}