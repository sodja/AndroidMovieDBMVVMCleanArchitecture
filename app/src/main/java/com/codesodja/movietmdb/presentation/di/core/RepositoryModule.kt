package com.codesodja.movietmdb.presentation.di.core

import com.codesodja.movietmdb.data.repository.artist.ArtistRepositoryImpl
import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.codesodja.movietmdb.data.repository.movie.MovieRepositoryImpl
import com.codesodja.movietmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.codesodja.movietmdb.data.repository.movie.datasource.MovieLocalDataSource
import com.codesodja.movietmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.codesodja.movietmdb.data.repository.tvshow.TvShowRepositoryImpl
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.codesodja.movietmdb.domain.repository.ArtistsRepository
import com.codesodja.movietmdb.domain.repository.MoviesRepository
import com.codesodja.movietmdb.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MoviesRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistsRepository {
        return ArtistRepositoryImpl(
            artistCacheDataSource,
            artistLocalDataSource,
            artistRemoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

}