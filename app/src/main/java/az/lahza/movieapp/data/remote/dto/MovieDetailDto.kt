package az.lahza.movieapp.data.remote.dto

import az.lahza.movieapp.domain.model.MovieDetail
import com.google.gson.annotations.SerializedName

data class MovieDetailDto(
    @SerializedName("Title")
    val title: String,

    @SerializedName("Year")
    val year: String,

    @SerializedName("Rated")
    val rated: String,

    @SerializedName("Released")
    val released: String,

    @SerializedName("Runtime")
    val runtime: String,

    @SerializedName("Genre")
    val genre: String,

    @SerializedName("Director")
    val director: String,

    @SerializedName("Writer")
    val writer: String,

    @SerializedName("Actors")
    val actors: String,

    @SerializedName("Plot")
    val plot: String,

    @SerializedName("Language")
    val language: String,

    @SerializedName("Country")
    val country: String,

    @SerializedName("Awards")
    val awards: String,

    @SerializedName("Poster")
    val poster: String,

    @SerializedName("Ratings")
    val ratings: List<Rating>,

    @SerializedName("Metascore")
    val metascore: String,

    val imdbRating: String,

    val imdbVotes: String,

    val imdbID: String,

    @SerializedName("Type")
    val type: String,

    @SerializedName("DVD")
    val dvd: String,

    @SerializedName("BoxOffice")
    val boxOffice: String,

    @SerializedName("Production")
    val production: String,

    @SerializedName("Website")
    val website: String,

    @SerializedName("Response")
    val response: String
)

data class Rating(
    @SerializedName("Source")
    val source: String,

    @SerializedName("Value")
    val value: String
)

fun MovieDetailDto.toMovieDetail() = MovieDetail(
    actors,
    awards,
    country,
    director,
    genre,
    language,
    poster,
    rated,
    released,
    title,
    type,
    year,
    imdbRating,
)
