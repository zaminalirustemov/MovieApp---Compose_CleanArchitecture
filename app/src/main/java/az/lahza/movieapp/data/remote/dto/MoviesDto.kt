package az.lahza.movieapp.data.remote.dto

import az.lahza.movieapp.domain.model.Movie
import com.google.gson.annotations.SerializedName


data class MoviesDto(
    @SerializedName("Search")
    val search: List<Search>,

    val totalResults: String,

    @SerializedName("Response")
    val response: String
)

data class Search(
    @SerializedName("Title")
    val title: String,

    @SerializedName("Year")
    val year: String,

    val imdbID: String,

    @SerializedName("Type")
    val type: Type,

    @SerializedName("Poster")
    val poster: String
)

enum class Type(val value: String) {
    @SerializedName("movie")
    Movie("movie"),

    @SerializedName("series")
    Series("series");
}

fun MoviesDto.toMovieList() = search.map { search ->
    Movie(
        search.poster,
        search.title,
        search.year,
        search.imdbID,
    )
}

