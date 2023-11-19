package br.com.movieapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.movieapp.core.util.Constants
import br.com.movieapp.movie_detail_feature.presentation.MovieDetailScreen
import br.com.movieapp.movie_detail_feature.presentation.MovieDetailViewModel
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
                    navController.navigate(BottomNavItem.MovieDetail.passMovieId(movieId = it))
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
                navigateToDetailMovie = {
                    navController.navigate(BottomNavItem.MovieDetail.passMovieId(movieId = it))
                }
            )
        }
        composable(BottomNavItem.MovieFavorite.route){
        }

        composable(route = BottomNavItem.MovieDetail.route,
        arguments = listOf(
            navArgument(Constants.MOVIE_DETAIL_ARGUMENT_KEY){
                type= NavType.IntType
                defaultValue = 0
            }
        )
        ){
            val viewModel : MovieDetailViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            val getMovieDetail = viewModel::getMovieDetail
            MovieDetailScreen(
                id = it.arguments?.getInt(Constants.MOVIE_DETAIL_ARGUMENT_KEY),
                uiState = uiState,
                getMovieDetail = getMovieDetail

            )


        }
    }

}