package com.codesodja.movietmdb.presentation.di.artist

import com.codesodja.movietmdb.domain.usecase.artist.GetArtistUseCase
import com.codesodja.movietmdb.domain.usecase.artist.UpdateArtistUseCase
import com.codesodja.movietmdb.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}