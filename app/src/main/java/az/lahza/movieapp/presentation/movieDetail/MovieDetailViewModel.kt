package az.lahza.movieapp.presentation.movieDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.lahza.movieapp.domain.useCase.getMovieDetail.GetMovieDetailsUseCase
import az.lahza.movieapp.util.Constants.IMDB_ID
import az.lahza.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state : State<MovieDetailState> = _state

    init {
        savedStateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }
    private fun getMovieDetail(imdbId:String){
        getMovieDetailsUseCase.execute(imdbId).onEach{response->
            when(response){
                is Resource.Success->{
                    _state.value = MovieDetailState(movie = response.data)
                }
                is Resource.Loading->{
                    _state.value = MovieDetailState(isLoading = true)
                }
                is Resource.Error->{
                    _state.value = MovieDetailState(error = response.message ?: "Error!")
                }
            }
        }.launchIn(viewModelScope)
    }
}