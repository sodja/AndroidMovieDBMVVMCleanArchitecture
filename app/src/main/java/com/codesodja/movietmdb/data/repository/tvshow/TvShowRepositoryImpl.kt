package com.codesodja.movietmdb.data.repository.tvshow

import android.util.Log
import com.codesodja.movietmdb.data.model.tvshow.TvShow
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.codesodja.movietmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.codesodja.movietmdb.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowsCacheToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowsFromApi(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val apiResponse = tvShowRemoteDataSource.getTvShows()
            val listOfPopularTv = apiResponse.body()
            if (listOfPopularTv!=null)
                tvShowList = listOfPopularTv.tvShows
        }catch (exception: Exception){
            Log.i("TvShowRepositoryImpl", "getTvShowsFromApi()"+exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val tvShowFromDB = tvShowLocalDataSource.getTvShowsFromDB()
            tvShowList = tvShowFromDB
        }catch (exception: Exception){
            Log.i("TvShowRepositoryImpl", "getTvShowsFromDB()"+exception.message.toString())
        }

        if (tvShowList.isNotEmpty()){
            return tvShowList
        } else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }
    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val tvShowFromCache = tvShowCacheDataSource.getTvShowsCacheFromCache()
            tvShowList = tvShowFromCache
        }catch (exception: Exception){
            Log.i("TvShowRepositoryImpl", "getTvShowsFromCache()"+exception.message.toString())
        }
        if (tvShowList.isNotEmpty()){
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsCacheToCache(tvShowList)
        }
        return tvShowList
    }
}