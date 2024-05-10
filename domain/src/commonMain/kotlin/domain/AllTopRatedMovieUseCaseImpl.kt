package domain

import androidx.paging.PagingData
import androidx.paging.map
import data.model.MovieEntity
import domain.paging.PaginatedContent
import domain.paging.PaginatedContentImpl
import data.repository.MovieRepository
import domain.mapper.MovieMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.MovieItem

class AllTopRatedMovieUseCaseImpl(private val repository: MovieRepository, private val mapper: MovieMapper,) :
    AllTopRatedMovieUseCase {

    override operator fun invoke(): Flow<PagingData<MovieItem>> {
        return PaginatedContentImpl { repository.topRatedMovie() }
            .flow.map { pagingData ->
                pagingData.map { mapper.map(it) }
            }
    }

}