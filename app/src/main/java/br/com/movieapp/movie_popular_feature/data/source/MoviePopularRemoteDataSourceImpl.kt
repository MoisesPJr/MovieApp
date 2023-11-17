package br.com.movieapp.movie_popular_feature.data.source

import br.com.movieapp.core.paging.MoviePagingSource
import br.com.movieapp.core.remote.MovieService
import br.com.movieapp.core.remote.response.MovieResponse
import br.com.movieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import javax.inject.Inject

class MoviePopularRemoteDataSourceImpl @Inject constructor(
    private val movieService: MovieService
) : MoviePopularRemoteDataSource {
    override fun getPopularMoviePagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return movieService.getPopularMovies(page)
    }
}