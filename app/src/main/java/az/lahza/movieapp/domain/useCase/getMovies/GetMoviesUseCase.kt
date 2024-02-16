package az.lahza.movieapp.domain.useCase.getMovies

import az.lahza.movieapp.data.remote.dto.toMovieList
import az.lahza.movieapp.domain.model.Movie
import az.lahza.movieapp.domain.repository.MovieRepository
import az.lahza.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun execute(search: String): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        try {
            val movieList = repository.getMovies(search)
            if (movieList.response == "True") {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error(message = "No movie found"))
            }
        }  catch (e: IOException) {
            emit(Resource.Error("Network Error: Unable to load data"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        }
    }
}