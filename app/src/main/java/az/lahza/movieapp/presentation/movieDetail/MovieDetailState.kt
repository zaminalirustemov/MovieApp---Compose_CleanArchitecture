package az.lahza.movieapp.presentation.movieDetail

import az.lahza.movieapp.domain.model.MovieDetail

class MovieDetailState (
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error : String = ""
)