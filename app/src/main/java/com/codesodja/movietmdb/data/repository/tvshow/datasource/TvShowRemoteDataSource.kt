package com.codesodja.movietmdb.data.repository.tvshow.datasource

import com.codesodja.movietmdb.data.model.tvshow.TvShow
import com.codesodja.movietmdb.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>
}