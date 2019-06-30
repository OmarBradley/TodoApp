package omarbradley.com.repository

import omarbradley.com.entity.Todo

interface TodoRepository {

    suspend fun postTodo(todo: Todo)

    suspend fun postTodos(todos: List<Todo>)

    suspend fun getTodos(): List<Todo>

    suspend fun getTodosBy(isCompleted: Boolean): List<Todo>

    suspend fun getTodosCount(): Int

    suspend fun getTodosCountBy(isCompleted: Boolean): Int

    suspend fun putTodo(todo: Todo)

    suspend fun putTodos(todos: List<Todo>)

    suspend fun deleteTodo(todo: Todo)

    suspend fun deleteTodos(todos: List<Todo>)

    suspend fun putTodoModelBy(title: String, description: String, id: Long)

    suspend fun putTodoModelBy(isCompleted: Boolean, id: Long)

}
