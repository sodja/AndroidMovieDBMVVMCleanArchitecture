package com.codesodja.movietmdb.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codesodja.movietmdb.domain.usecase.tvshow.GetTvShowsUseCase
import com.codesodja.movietmdb.domain.usecase.tvshow.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvViewModel(getTvShowsUseCase, updateTvShowUseCase) as T
    }
}