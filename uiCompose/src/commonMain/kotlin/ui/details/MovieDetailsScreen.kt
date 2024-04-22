package ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import model.MovieDetails
import org.koin.compose.koinInject
import ui.MovieUiState
import ui.UIStateView


@Composable
fun DetailsScreen(movieId: Int) {

    val detailsViewModel = koinInject<MovieDetailViewModel>()

    val state: State<MovieUiState<out MovieDetails>> = detailsViewModel.movieDetail(movieId).collectAsState()

    UIStateView(state) {
        UIMovieDetails(it)
    }

}