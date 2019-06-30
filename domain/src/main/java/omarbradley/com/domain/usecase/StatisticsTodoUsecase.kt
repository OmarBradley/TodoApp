package omarbradley.com.domain.usecase

import omarbradley.com.repository.TodoRepository
import omarbradley.com.util.withIoContext

class StatisticsTodoUsecase(
    private val todoRepository: TodoRepository
) {

    suspend fun getActiveTodosCount() = withIoContext {
        todoRepository.getTodosCountBy(false)
    }

    suspend fun getCompletedTodosCount() = withIoContext {
        todoRepository.getTodosCountBy(true)
    }

    suspend fun getTotalTodosCount() = withIoContext {
        todoRepository.getTodosCount()
    }

}
