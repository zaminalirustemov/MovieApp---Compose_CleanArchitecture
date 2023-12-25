package az.lahza.movieapp.data.repository

import az.lahza.movieapp.data.remote.MovieAPI
import az.lahza.movieapp.data.remote.dto.MovieDetailDto
import az.lahza.movieapp.data.remote.dto.MoviesDto
import az.lahza.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieAPI) :MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }
}