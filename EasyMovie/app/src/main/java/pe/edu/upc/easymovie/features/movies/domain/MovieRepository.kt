package pe.edu.upc.easymovie.features.movies.domain

interface MovieRepository {

    suspend fun searchMovie(query: String): List<Movie>

    suspend fun insertFavorite(movie: Movie)

    suspend fun deleteFavorite(movie: Movie)

    suspend fun getAllFavorites(): List<Movie>
}