package com.codesodja.movietmdb.presentation.di.core

import com.codesodja.movietmdb.presentation.di.artist.ArtistSubComponent
import com.codesodja.movietmdb.presentation.di.movie.MovieSubComponent
import com.codesodja.movietmdb.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        CacheDataModule::class,
        LocalDataModule::class,
        RemoteDataModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}