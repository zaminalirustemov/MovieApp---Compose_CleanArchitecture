package az.lahza.movieapp.presentation.movies

sealed class MoviesEvent {
    data class Search(val search: String) : MoviesEvent()
}