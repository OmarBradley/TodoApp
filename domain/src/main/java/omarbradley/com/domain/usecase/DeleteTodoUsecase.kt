package omarbradley.com.domain.usecase

import omarbradley.com.entity.Todo
import omarbradley.com.repository.TodoRepository
import omarbradley.com.util.withIoContext

class DeleteTodoUsecase(
    private val todoRepository: TodoRepository
) {

    suspend fun deleteTodo(todo: Todo) = withIoContext {
        todoRepository.deleteTodo(todo)
    }

    suspend fun clearCompletedTodo() = withIoContext {
        val completedTodos = todoRepository.getTodosBy(true)
        todoRepository.deleteTodos(completedTodos)
    }

}
