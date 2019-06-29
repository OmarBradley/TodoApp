package omarbradley.com.entity

data class Todo(
    val id: Long,
    val title: String,
    val description: String,
    val createTimeMillis: Long,
    val isCompleted: Boolean
)
