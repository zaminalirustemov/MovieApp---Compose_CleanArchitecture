package az.lahza.movieapp.domain.repository

import az.lahza.movieapp.data.remote.dto.MovieDetailDto
import az.lahza.movieapp.data.remote.dto.MoviesDto

interface MovieRepository {
    suspend fun getMovies(search : String): MoviesDto
    suspend fun getMovieDetail(imdbId : String): MovieDetailDto
}