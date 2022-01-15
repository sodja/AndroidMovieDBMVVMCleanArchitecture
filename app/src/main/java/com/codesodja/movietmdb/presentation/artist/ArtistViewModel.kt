package com.codesodja.movietmdb.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.codesodja.movietmdb.domain.usecase.artist.GetArtistUseCase
import com.codesodja.movietmdb.domain.usecase.artist.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}