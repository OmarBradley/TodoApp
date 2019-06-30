package omarbradley.com.domain.usecase

import omarbradley.com.repository.TodoRepository
import omarbradley.com.util.withIoContext

class GetTodoUsecase(
    private val todoRepository: TodoRepository
) {

    suspend fun getAllTodos() = withIoContext {
        todoRepository.getTodos()
    }

    suspend fun getActiveTodos() = withIoContext {
        todoRepository.getTodosBy(false)
    }

    suspend fun getCompletedTodos() = withIoContext {
        todoRepository.getTodosBy(true)
    }

}
