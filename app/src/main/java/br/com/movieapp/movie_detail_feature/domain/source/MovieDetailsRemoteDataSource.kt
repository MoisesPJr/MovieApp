package br.com.movieapp.movie_detail_feature.domain.source

import br.com.movieapp.core.domain.model.MovieDetails
import br.com.movieapp.core.paging.MovieSimilarPagingSource
import br.com.movieapp.core.remote.response.MovieResponse

interface MovieDetailsRemoteDataSource {

    suspend fun getMovieDetails(movieId: Int): MovieDetails

    suspend fun getMoviesSimilar(page: Int, movieId: Int): MovieResponse

    fun getSimilarMoviesPagingSource(movieId: Int): MovieSimilarPagingSource


}