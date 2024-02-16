package az.lahza.movieapp.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import az.lahza.movieapp.domain.model.Movie
import az.lahza.movieapp.presentation.Screen
import az.lahza.movieapp.presentation.movies.MoviesEvent
import az.lahza.movieapp.presentation.movies.MoviesState
import az.lahza.movieapp.presentation.movies.MoviesViewModel

@Composable
fun MovieScreen(
    navController: NavController,
    viewModel: MoviesViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        MovieContent(
            state = state,
            onMovieClick = { movieId ->
                navController.navigate(Screen.MovieDetailScreen.route + "/$movieId")
            },
            onSearch = { query ->
                viewModel.onEvent(MoviesEvent.Search(query))
            }
        )
    }
}

@Composable
fun MovieContent(
    state: MoviesState,
    onMovieClick: (String) -> Unit,
    onSearch: (String) -> Unit
) {
    Column {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            hint = "Batman",
            onSearch = onSearch
        )

        MovieList(state.movies, onMovieClick)
    }
}

@Composable
fun MovieList(movies: List<Movie>, onItemClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(movies) { movie ->
            MovieListRow(movie = movie, onItemClick = {
                onItemClick(movie.imdbID)
            })
        }
    }
}
