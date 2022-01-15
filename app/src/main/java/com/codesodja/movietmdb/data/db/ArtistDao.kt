package com.codesodja.movietmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.codesodja.movietmdb.data.model.artist.Artist
import com.codesodja.movietmdb.data.model.movie.Movie


@Dao
interface ArtistDao {

    @Insert(onConflict = REPLACE)
    suspend fun saveArtists(artist: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>
}