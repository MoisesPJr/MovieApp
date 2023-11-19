package br.com.movieapp.movie_favorite_feature.di

import br.com.movieapp.core.data.local.dao.MovieDao
import br.com.movieapp.movie_favorite_feature.data.repository.MovieFavoriteRepositoryImpl
import br.com.movieapp.movie_favorite_feature.data.source.MovieFavoriteLocalDataSourceImpl
import br.com.movieapp.movie_favorite_feature.domain.repository.MovieFavoriteRepository
import br.com.movieapp.movie_favorite_feature.domain.source.MovieFavoriteLocalDataSource
import br.com.movieapp.movie_favorite_feature.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovieFavoriteModule {


    @Provides
    @Singleton
    fun provideFavoriteLocalDataSource(dao: MovieDao): MovieFavoriteLocalDataSource{
        return MovieFavoriteLocalDataSourceImpl(dao)
    }

    @Provides
    @Singleton
    fun provideMovieFavoriteRepository(localDataSource: MovieFavoriteLocalDataSource): MovieFavoriteRepository{
        return  MovieFavoriteRepositoryImpl(localDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMovieFavoriteUseCase(movieRepository: MovieFavoriteRepository): GetMoviesFavoriteUseCase {
        return GetMoviesFavoriteUseCaseImpl(movieRepository)
    }

    @Provides
    @Singleton
    fun provideAddMovieFavoriteUseCase(movieRepository: MovieFavoriteRepository): AddMovieFavoriteUseCase {
        return AddMovieFavoriteUseCaseImpl(movieRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteMovieFavoriteUseCase(movieRepository: MovieFavoriteRepository): DeleteMovieFavoriteUseCase {
        return DeleteMovieFavoriteUseCaseImpl(movieRepository)
    }

    @Provides
    @Singleton
    fun provideIsMovieFavoriteUseCase(movieRepository: MovieFavoriteRepository): IsMovieFavoriteUseCase {
        return IsMovieFavoriteUseCaseImpl(movieRepository)
    }


}