package br.com.movieapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.movieapp.movie_popular_feature.presentation.MoviePopularScreen
import br.com.movieapp.movie_popular_feature.presentation.MoviePopularViewModel
import br.com.movieapp.search_movie_feature.presentation.MovieSearchEvent
import br.com.movieapp.search_movie_feature.presentation.MovieSearchScreen
import br.com.movieapp.search_movie_feature.presentation.MovieSearchViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.MoviePopular.route
    ){
        composable(BottomNavItem.MoviePopular.route){

            val viewmodel : MoviePopularViewModel = hiltViewModel()
             val uiState =  viewmodel.uiState
            MoviePopularScreen(
                uiState = uiState,
                navigateToDetailMovie = {

                }
            )
        }
        composable(BottomNavItem.MovieSearch.route){
            val viewmodel : MovieSearchViewModel = hiltViewModel()
            val uiState = viewmodel.uiState
            val onEvent: (MovieSearchEvent) -> Unit = viewmodel::event
            val onFetch: (String) -> Unit = viewmodel::fetch

            MovieSearchScreen(
                uiState = uiState,
                onEvent = onEvent,
                onFetch = onFetch,
                navigateToDetailMovie = {}
            )
        }
        composable(BottomNavItem.MovieFavorite.route){

        }
    }

}