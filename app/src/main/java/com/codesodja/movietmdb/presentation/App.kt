package com.codesodja.movietmdb.presentation

import android.app.Application
import com.codesodja.movietmdb.BuildConfig
import com.codesodja.movietmdb.presentation.di.Injector
import com.codesodja.movietmdb.presentation.di.artist.ArtistSubComponent
import com.codesodja.movietmdb.presentation.di.core.*
import com.codesodja.movietmdb.presentation.di.movie.MovieSubComponent
import com.codesodja.movietmdb.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}