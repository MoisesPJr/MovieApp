package br.com.movieapp.movie_detail_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import br.com.movieapp.R
import br.com.movieapp.core.domain.model.Movie
import br.com.movieapp.core.domain.model.MovieDetails
import br.com.movieapp.movie_detail_feature.data.mapper.toMovie
import br.com.movieapp.movie_detail_feature.presentation.MovieInfoContent
import br.com.movieapp.ui.theme.black
import br.com.movieapp.ui.theme.white
import br.com.movieapp.ui.theme.yellow
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

@Composable
fun MovieDetailsContent(

    modifier: Modifier = Modifier,
    movieDetails: MovieDetails?,
    pagingMoviesSimilar: LazyPagingItems<Movie>,
    isLoading: Boolean,
    isError: String,
    iconColor: Color,
    onAddFavorite: (Movie) -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(black)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MovieDetailBackdrop(
                imageUrl = movieDetails?.backdropPathUrl.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                IconButton(
                    onClick = {
                        movieDetails?.toMovie()?.let {
                            onAddFavorite(it)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "",
                        tint = iconColor
                    )
                }
            }

            Text(
                text = movieDetails?.title.toString(),
                color = white,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)

            )

            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                mainAxisSpacing = 10.dp,
                mainAxisAlignment = MainAxisAlignment.Center,
                crossAxisSpacing = 10.dp,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                movieDetails?.genre?.forEach { genre ->
                    MovieDetailGenreTag(genre = genre)
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            MovieInfoContent(
                movieDetails = movieDetails,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            RatingBar(
                rating = (movieDetails?.voteAverage?.toFloat()?.div(2f)) ?: 0f,
                modifier = Modifier.height(15.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            MovieDetailOverview(
                overview = movieDetails?.overview.toString(),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(R.string.movies_similar),
                color = white,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                modifier = Modifier.align(alignment = Alignment.Start)
                    .padding(horizontal = 8.dp)
            )
        }

        if (isError.isNotEmpty()) {
            Text(
                text = isError,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .align(Alignment.TopCenter)
            )
        }

        if(isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.TopCenter),
                color = yellow
            )
        }

        MovieDetailSimilarMovies(
            pagingMoviesSimilar = pagingMoviesSimilar,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .align(Alignment.BottomEnd)

        )

    }

}
