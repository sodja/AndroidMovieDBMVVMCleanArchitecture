package com.codesodja.movietmdb.data.repository.tvshow.datasourceImpl

import com.codesodja.movietmdb.data.api.MovieDB
import com.codesodja.movietmdb.data.model.tvshow.TvShowList
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response


class TvShowRemoteDataSourceImpl(
    private val movieDB: MovieDB, private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = movieDB.getPopularTvShows(apiKey)
}