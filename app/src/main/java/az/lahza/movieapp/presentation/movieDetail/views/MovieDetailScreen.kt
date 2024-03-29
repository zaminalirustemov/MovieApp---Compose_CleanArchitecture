package az.lahza.movieapp.presentation.movieDetail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import az.lahza.movieapp.presentation.movieDetail.MovieDetailViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
) {
    val state = movieDetailViewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        state.movie?.let { movie ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally
            ) {
                Image(
                    painter = rememberImagePainter(data = movie.poster),
                    contentDescription = movie.title,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(300.dp, 300.dp)
                        .clip(RectangleShape)
                        .align(CenterHorizontally)
                )

                Text(
                    text = movie.title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White
                )

                Text(
                    text = movie.year,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White
                )

                Text(
                    text = movie.actors,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White
                )

                Text(
                    text = movie.country,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White
                )

                Text(
                    text = "Director: ${movie.director}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White
                )

                Text(
                    text = "IMDB Rating: ${movie.imdbRating}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White
                )

            }

        }

        if (state.error.isNotBlank()) {
            Text(text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .align(Alignment.Center)
            )
        }

        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}