package omarbradley.com.repository.local.dummy

import omarbradley.com.entity.Todo
import omarbradley.com.util.date.currentTimeMillis

val dummyTodo = Todo(
    createTimeMillis = currentTimeMillis,
    title = "Dummy",
    isCompleted = false,
    description = "Dummydescription"
)

val dummyTodos = listOf(
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = true,
        description = "Dummydescription"
    ),
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = true,
        description = "Dummydescription"
    ),
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = true,
        description = "Dummydescription"
    ),
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = true,
        description = "Dummydescription"
    ),
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = false,
        description = "Dummydescription"
    ),
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = false,
        description = "Dummydescription"
    )
)

val isCompletedDummyTodosCount = dummyTodos
    .filter(Todo::isCompleted)
    .count()


val dummyTodoUsingPutsTest = listOf(
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = false,
        description = "Dummydescription"
    ),
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = false,
        description = "Dummydescription"
    )
)

val dummyTodoUsingDeleteTodos_allTodosDelete_Test = listOf(
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = false,
        description = "Dummydescription"
    ),
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = false,
        description = "Dummydescription"
    ),
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = true,
        description = "Dummydescription"
    ),
    Todo(
        createTimeMillis = currentTimeMillis,
        title = "Dummy",
        isCompleted = true,
        description = "Dummydescription"
    )
)

val dummyIsNotCompletedTodo = Todo(
    createTimeMillis = currentTimeMillis,
    title = "Dummy",
    isCompleted = false,
    description = "Dummydescription"
)
