package omarbradley.com.repository.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import omarbradley.com.entity.Todo

@Entity(tableName = "todo")
data class TodoModel(
    var title: String,
    var description: String,
    var createTimeMillis: Long,
    var isCompleted: Boolean,

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)

fun TodoModel.toTodo() =
    Todo(
        title = title,
        description = description,
        createTimeMillis = createTimeMillis,
        isCompleted = isCompleted,
        id = id
    )

fun Todo.toTodoModel() =
    TodoModel(
        title = title,
        description = description,
        createTimeMillis = createTimeMillis,
        isCompleted = isCompleted,
        id = id
    )

fun List<Todo>.toTodoModels() = map(Todo::toTodoModel)

fun List<Todo>.toTodoModelsArray() = toTodoModels().toTypedArray()

fun List<TodoModel>.toTodos() = map(TodoModel::toTodo)
