package com.codesodja.movietmdb.presentation.di.core

import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.codesodja.movietmdb.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.codesodja.movietmdb.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.codesodja.movietmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.codesodja.movietmdb.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.codesodja.movietmdb.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Provides
    @Singleton
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}