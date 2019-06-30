package omarbradley.com.repository.local.repository

import omarbradley.com.entity.Todo
import omarbradley.com.repository.TodoRepository
import omarbradley.com.repository.local.dao.TodoModelDao
import omarbradley.com.repository.local.model.toTodoModel
import omarbradley.com.repository.local.model.toTodoModelsArray
import omarbradley.com.repository.local.model.toTodos

class LocalTodoRepository(
    private val todoModelDao: TodoModelDao
) : TodoRepository {

    override suspend fun postTodo(todo: Todo) =
        todoModelDao.insert(todo.toTodoModel())

    override suspend fun postTodos(todos: List<Todo>) =
        todoModelDao.insert(*todos.toTodoModelsArray())

    override suspend fun getTodos(): List<Todo> =
        todoModelDao.selectTodoModels().toTodos()

    override suspend fun getTodosBy(isCompleted: Boolean): List<Todo> =
        todoModelDao.selectTodoModelsBy(isCompleted).toTodos()

    override suspend fun getTodosCount(): Int =
        todoModelDao.selectCountTodoModels()

    override suspend fun getTodosCountBy(isCompleted: Boolean): Int =
        todoModelDao.selectCountTodoModelsBy(isCompleted)

    override suspend fun putTodo(todo: Todo) {
        todoModelDao.update(todo.toTodoModel())
    }

    override suspend fun putTodos(todos: List<Todo>) {
        todoModelDao.update(*todos.toTodoModelsArray())
    }

    override suspend fun deleteTodo(todo: Todo) {
        todoModelDao.delete(todo.toTodoModel())
    }

    override suspend fun deleteTodos(todos: List<Todo>) {
        todoModelDao.delete(*todos.toTodoModelsArray())
    }

    override suspend fun putTodoModelBy(isCompleted: Boolean, id: Long) {
        todoModelDao.updateTodoModelBy(isCompleted, id)
    }

    override suspend fun putTodoModelBy(title: String, description: String, id: Long) {
        todoModelDao.updateTodoModelBy(title, description, id)
    }

}
