package com.codesodja.movietmdb.data.repository.artist

import android.util.Log
import com.codesodja.movietmdb.data.model.artist.Artist
import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.codesodja.movietmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.codesodja.movietmdb.domain.repository.ArtistsRepository

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : ArtistsRepository {
    override suspend fun getArtists(): List<Artist>? = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtist = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist)
        artistCacheDataSource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val apiResponse = artistRemoteDataSource.getArtists()
            val listOfPopularArtist = apiResponse.body()
            if (listOfPopularArtist != null) {
                artistList = listOfPopularArtist.artists
            }
        } catch (exception: Exception) {
            Log.i("ArtistRepositoryImpl", "getArtistsFromAPI()" + exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val artistFromLocalDB = artistLocalDataSource.getArtistsFromDB()
            artistList = artistFromLocalDB
        } catch (exception: Exception) {
            Log.i("ArtistRepositoryImpl", "getArtistsFromDB()" + exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val artistsFromCache = artistCacheDataSource.getArtistsFromCache()
            artistList = artistsFromCache
        }catch (exception: Exception){
            Log.i("ArtistRepositoryImpl", "getArtistsFromCache()" + exception.message.toString())
        }

        if (artistList.isNotEmpty()){
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}