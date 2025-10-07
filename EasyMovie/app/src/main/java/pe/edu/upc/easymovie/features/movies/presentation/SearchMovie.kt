package pe.edu.upc.easymovie.features.movies.presentation

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Preview(showBackground = true)
@Composable
fun SearchMovie(
    modifier: Modifier = Modifier,
    viewModel: SearchMovieViewModel = hiltViewModel()
) {

    val query by viewModel.query.collectAsState()
    val movies by viewModel.movies.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {

        OutlinedTextField(
            value = query,
            onValueChange = viewModel::onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(
                    onClick = viewModel::searchMovie
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null
                    )
                }
            }
        )
        LazyColumn {
            items(movies) { movie ->
                MovieCard(movie){
                    viewModel.toggleFavorite(movie)
                }
            }
        }
    }
}
