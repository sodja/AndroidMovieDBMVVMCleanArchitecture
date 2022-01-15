package com.codesodja.movietmdb.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.codesodja.movietmdb.data.db.ArtistDao
import com.codesodja.movietmdb.data.db.MovieDao
import com.codesodja.movietmdb.data.db.MovieDatabase
import com.codesodja.movietmdb.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): MovieDatabase{
        return Room.databaseBuilder(context, MovieDatabase::class.java, "moviedbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao{
        return movieDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(movieDatabase: MovieDatabase): ArtistDao{
        return movieDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(movieDatabase: MovieDatabase): TvShowDao{
        return movieDatabase.tvShowDao()
    }
}