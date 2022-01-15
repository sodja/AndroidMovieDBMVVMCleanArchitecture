package com.codesodja.movietmdb.data.repository.tvshow.datasourceImpl

import com.codesodja.movietmdb.data.model.tvshow.TvShow
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsCacheFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsCacheToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}