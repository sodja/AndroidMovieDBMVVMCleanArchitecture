package com.codesodja.movietmdb.presentation.di.tvshow

import com.codesodja.movietmdb.domain.usecase.tvshow.GetTvShowsUseCase
import com.codesodja.movietmdb.domain.usecase.tvshow.UpdateTvShowUseCase
import com.codesodja.movietmdb.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowUseCase)
    }
}