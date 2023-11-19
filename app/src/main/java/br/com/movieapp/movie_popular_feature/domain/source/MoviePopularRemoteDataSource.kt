package br.com.movieapp.movie_popular_feature.domain.source

import br.com.movieapp.core.paging.MoviePagingSource
import br.com.movieapp.core.data.remote.response.MovieResponse

interface MoviePopularRemoteDataSource {

    fun getPopularMoviePagingSource():MoviePagingSource

    suspend fun getPopularMovies(page: Int): MovieResponse

}