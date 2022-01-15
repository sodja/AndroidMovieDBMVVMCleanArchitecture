package com.codesodja.movietmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.codesodja.movietmdb.data.model.movie.Movie
import com.codesodja.movietmdb.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getTvShows(): List<TvShow>
}