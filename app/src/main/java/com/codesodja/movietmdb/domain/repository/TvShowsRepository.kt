package com.codesodja.movietmdb.domain.repository

import com.codesodja.movietmdb.data.model.tvshow.TvShow

interface TvShowsRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}