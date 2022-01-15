package com.codesodja.movietmdb.domain.usecase.movie

import com.codesodja.movietmdb.data.model.movie.Movie
import com.codesodja.movietmdb.domain.repository.MoviesRepository

class UpdateMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute():List<Movie>? = moviesRepository.updateMovies()
}