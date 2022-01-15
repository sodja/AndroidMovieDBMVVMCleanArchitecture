package com.codesodja.movietmdb.data.repository.tvshow.datasource

import com.codesodja.movietmdb.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsCacheFromCache(): List<TvShow>
    suspend fun saveTvShowsCacheToCache(tvShows: List<TvShow>)
}