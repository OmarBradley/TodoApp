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

}
