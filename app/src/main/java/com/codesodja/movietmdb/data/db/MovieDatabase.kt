package com.codesodja.movietmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codesodja.movietmdb.data.model.artist.Artist
import com.codesodja.movietmdb.data.model.movie.Movie
import com.codesodja.movietmdb.data.model.tvshow.TvShow

@Database(entities = [Artist::class, Movie::class, TvShow::class], version = 1, exportSchema = false)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}