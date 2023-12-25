package az.lahza.movieapp.domain.useCase.getMovieDetail

import az.lahza.movieapp.data.remote.dto.toMovieDetail
import az.lahza.movieapp.domain.model.MovieDetail
import az.lahza.movieapp.domain.repository.MovieRepository
import az.lahza.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun execute(imdbId: String): Flow<Resource<MovieDetail>> = flow {
        emit(Resource.Loading())
        try {
            val movieDetails = repository.getMovieDetail(imdbId = imdbId)
            emit(Resource.Success(movieDetails.toMovieDetail()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown Error Occurred"))
        }
    }
}