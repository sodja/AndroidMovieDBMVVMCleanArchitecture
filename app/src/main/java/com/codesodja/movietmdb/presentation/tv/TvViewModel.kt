package com.codesodja.movietmdb.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.codesodja.movietmdb.domain.usecase.tvshow.GetTvShowsUseCase
import com.codesodja.movietmdb.domain.usecase.tvshow.UpdateTvShowUseCase

class TvViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList = updateTvShowUseCase.execute()
        emit(tvShowList)
    }
}