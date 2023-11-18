package br.com.movieapp.movie_detail_feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.movieapp.R
import br.com.movieapp.core.domain.model.MovieDetails


@Composable
fun MovieInfoContent(
    movieDetails: MovieDetails?,
    modifier: Modifier = Modifier
) {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        MovieDetailInfo(
            name = stringResource(R.string.vote_average),
            value = movieDetails?.voteAverage.toString()
        )
        MovieDetailInfo(
            name = stringResource(
                id = R.string.duration,
                movieDetails?.duration.toString()
            ),
            value = movieDetails?.voteAverage.toString()
        )
        MovieDetailInfo(
            name = stringResource(R.string.release_date),
            value = movieDetails?.releaseDate.toString()
        )
    }

}


@Composable
fun MovieDetailInfo(
    name: String,
    value: String
) {

    Column {
        Text(
            text = name,
            style = MaterialTheme.typography.subtitle2.copy(fontSize = 13.sp, letterSpacing = 1.sp),
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = value,
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.SemiBold),
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(top = 4.dp)
        )
    }


}