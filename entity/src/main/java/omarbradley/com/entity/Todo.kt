package omarbradley.com.entity

data class Todo(
    var title: String,
    var description: String,
    var createTimeMillis: Long,
    var isCompleted: Boolean,
    var id: Long = 0
)
