package omarbradley.com.repository.local.dao

import androidx.room.Dao
import androidx.room.Query
import omarbradley.com.repository.local.model.TodoModel
import omarbradley.com.util.base.BaseDao

@Dao
interface TodoModelDao : BaseDao<TodoModel> {

    @Query("SELECT * FROM todo ORDER BY createTimeMillis desc")
    suspend fun selectTodoModels(): List<TodoModel>

    @Query("SELECT COUNT(*) FROM todo")
    suspend fun selectCountTodoModels(): Int

    @Query("SELECT * FROM todo WHERE isCompleted = :isCompleted ORDER BY createTimeMillis desc")
    suspend fun selectTodoModelsBy(isCompleted: Boolean): List<TodoModel>

    @Query("SELECT COUNT(*) FROM todo WHERE isCompleted = :isCompleted")
    suspend fun selectCountTodoModelsBy(isCompleted: Boolean): Int

    @Query("UPDATE todo SET title = :title, description = :description WHERE id =:id")
    suspend fun updateTodoModelBy(title: String, description: String, id: Long)

    @Query("UPDATE todo SET isCompleted = :isCompleted WHERE id =:id")
    suspend fun updateTodoModelBy(isCompleted: Boolean, id: Long)

}
