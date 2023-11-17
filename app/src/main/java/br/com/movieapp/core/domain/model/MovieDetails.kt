package br.com.movieapp.core.domain.model

import br.com.movieapp.core.remote.model.Genre

data class MovieDetails(
    val id: Int,
    val title:String,
    val genre: List<String>,
    val overview: String?,
    val backdropPathUrl: String?,
    val releaseDate: String?,
    val voteAverage: Double,
    val duration: Int = 0,
    val voteCount: Int = 0
)
