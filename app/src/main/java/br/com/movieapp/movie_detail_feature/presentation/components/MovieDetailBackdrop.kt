package br.com.movieapp.movie_detail_feature.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import br.com.movieapp.R
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MovieDetailBackdrop(
    imageUrl: String,
    modifier: Modifier
) {

    Box(modifier = modifier){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .error(R.drawable.ic_error_image)
                .placeholder(R.drawable.ic_placeholder)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}