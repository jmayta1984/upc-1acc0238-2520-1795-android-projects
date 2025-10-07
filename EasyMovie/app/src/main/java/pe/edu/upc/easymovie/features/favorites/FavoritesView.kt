package pe.edu.upc.easymovie.features.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import pe.edu.upc.easymovie.features.movies.presentation.MovieCard
import pe.edu.upc.easymovie.features.movies.presentation.SearchMovieViewModel

@Composable
fun FavoritesMovie(
    modifier: Modifier = Modifier,
    viewModel: FavoritesViewModel = hiltViewModel()
) {

    val movies by viewModel.favorites.collectAsState()




    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(movies) { movie ->
            FavoriteCard(movie) {
                viewModel.deleteFavorite(movie)
            }
        }
    }

}
