package com.codesodja.movietmdb.presentation.di

import com.codesodja.movietmdb.presentation.di.artist.ArtistSubComponent
import com.codesodja.movietmdb.presentation.di.movie.MovieSubComponent
import com.codesodja.movietmdb.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent

}