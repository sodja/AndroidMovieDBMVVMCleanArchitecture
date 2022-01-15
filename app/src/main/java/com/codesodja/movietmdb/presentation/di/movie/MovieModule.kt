package com.codesodja.movietmdb.presentation.di.movie

import com.codesodja.movietmdb.domain.usecase.movie.GetMoviesUseCase
import com.codesodja.movietmdb.domain.usecase.movie.UpdateMoviesUseCase
import com.codesodja.movietmdb.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}