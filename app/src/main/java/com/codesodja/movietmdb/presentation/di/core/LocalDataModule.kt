package com.codesodja.movietmdb.presentation.di.core

import com.codesodja.movietmdb.data.api.MovieDB
import com.codesodja.movietmdb.data.db.ArtistDao
import com.codesodja.movietmdb.data.db.MovieDao
import com.codesodja.movietmdb.data.db.MovieDatabase
import com.codesodja.movietmdb.data.db.TvShowDao
import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.codesodja.movietmdb.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.codesodja.movietmdb.data.repository.movie.datasource.MovieLocalDataSource
import com.codesodja.movietmdb.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.codesodja.movietmdb.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Provides
    @Singleton
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(
            movieDao
        )
    }
    @Provides
    @Singleton
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(
            artistDao
        )
    }
    @Provides
    @Singleton
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(
            tvShowDao
        )
    }
}