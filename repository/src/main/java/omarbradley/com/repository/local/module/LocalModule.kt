package omarbradley.com.repository.local.module

import androidx.room.Room
import omarbradley.com.repository.local.db.TodoAppDatabase
import omarbradley.com.repository.local.repository.LocalTodoRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {

    single { LocalTodoRepository(get()) }
    single { get<TodoAppDatabase>().todoDao() }
    single {
        Room.databaseBuilder(androidApplication(), TodoAppDatabase::class.java, "todo-app-db")
            .build()
    }
}


