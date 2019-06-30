package omarbradley.com.domain.usecase

import omarbradley.com.entity.Todo
import omarbradley.com.repository.TodoRepository
import omarbradley.com.util.withIoContext

class CreateTodoUsecase(
    private val todoRepository: TodoRepository
) {

    suspend fun createTodo(todo: Todo) = withIoContext {
        todoRepository.postTodo(todo)
    }

}
