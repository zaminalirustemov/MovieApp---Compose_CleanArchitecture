package az.lahza.movieapp.presentation.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import az.lahza.movieapp.domain.model.Movie
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@Composable
fun MovieListRow(
    movie: Movie,
    onItemClick: (Movie) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MovieImage(movie.poster, movie.title)
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MovieText(movie.title, MaterialTheme.typography.titleMedium)
            MovieText(movie.year, MaterialTheme.typography.titleSmall)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieImage(posterUrl: String, contentDescription: String) {
    Image(
        painter = rememberImagePainter(data = posterUrl),
        contentDescription = contentDescription,
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp, 200.dp)
            .clip(RectangleShape)
    )
}

@Composable
fun MovieText(text: String, textStyle: TextStyle) {
    Text(
        text = text,
        color = Color.White,
        style = textStyle,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center
    )
}
