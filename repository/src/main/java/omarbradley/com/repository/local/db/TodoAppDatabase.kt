package omarbradley.com.repository.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import omarbradley.com.repository.local.dao.TodoModelDao
import omarbradley.com.repository.local.model.TodoModel


@Database(entities = [TodoModel::class], version = 1, exportSchema = true)
abstract class TodoAppDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoModelDao

}
