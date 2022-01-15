package com.codesodja.movietmdb.domain.usecase.tvshow

import com.codesodja.movietmdb.data.model.tvshow.TvShow
import com.codesodja.movietmdb.domain.repository.TvShowsRepository

class GetTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute(): List<TvShow>? = tvShowsRepository.getTvShows()
}