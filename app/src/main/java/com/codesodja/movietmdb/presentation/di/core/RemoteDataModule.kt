package com.codesodja.movietmdb.presentation.di.core

import com.codesodja.movietmdb.data.api.MovieDB
import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.codesodja.movietmdb.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.codesodja.movietmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.codesodja.movietmdb.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.codesodja.movietmdb.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(movieDB: MovieDB): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            movieDB,
            apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(movieDB: MovieDB): TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(
            movieDB,
            apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(movieDB: MovieDB): ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(
            movieDB,
            apiKey
        )
    }
}