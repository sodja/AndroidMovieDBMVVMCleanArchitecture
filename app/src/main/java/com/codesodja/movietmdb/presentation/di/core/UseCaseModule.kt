package com.codesodja.movietmdb.presentation.di.core

import com.codesodja.movietmdb.domain.repository.ArtistsRepository
import com.codesodja.movietmdb.domain.repository.MoviesRepository
import com.codesodja.movietmdb.domain.repository.TvShowsRepository
import com.codesodja.movietmdb.domain.usecase.artist.GetArtistUseCase
import com.codesodja.movietmdb.domain.usecase.artist.UpdateArtistUseCase
import com.codesodja.movietmdb.domain.usecase.movie.GetMoviesUseCase
import com.codesodja.movietmdb.domain.usecase.movie.UpdateMoviesUseCase
import com.codesodja.movietmdb.domain.usecase.tvshow.GetTvShowsUseCase
import com.codesodja.movietmdb.domain.usecase.tvshow.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MoviesRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MoviesRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetArtistsUseCase(artistsRepository: ArtistsRepository): GetArtistUseCase{
        return GetArtistUseCase(artistsRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistsUseCase(artistsRepository: ArtistsRepository): UpdateArtistUseCase{
        return UpdateArtistUseCase(artistsRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowsUseCase(tvShowsRepository: TvShowsRepository): GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowsRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowsUseCase(tvShowsRepository: TvShowsRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowsRepository)
    }
}