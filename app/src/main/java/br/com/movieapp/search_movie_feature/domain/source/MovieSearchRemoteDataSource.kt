package br.com.movieapp.search_movie_feature.domain.source

import br.com.movieapp.core.paging.MovieSearchPagingSource
import br.com.movieapp.core.remote.response.SearchResponse

interface MovieSearchRemoteDataSource {

    fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource

    suspend fun getSearchMovies(page: Int, query: String): SearchResponse

}