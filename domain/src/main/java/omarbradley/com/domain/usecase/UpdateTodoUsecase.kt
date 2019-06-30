package omarbradley.com.domain.usecase

import omarbradley.com.repository.TodoRepository
import omarbradley.com.util.withIoContext

class UpdateTodoUsecase(
    private val todoRepository: TodoRepository
) {

    suspend fun updateTodoContent(title: String, description: String, id: Long) = withIoContext {
        todoRepository.putTodoModelBy(title, description, id)
    }

    suspend fun updateTodoCompleted(isCompleted: Boolean, id: Long) = withIoContext {
        todoRepository.putTodoModelBy(isCompleted, id)
    }

}
