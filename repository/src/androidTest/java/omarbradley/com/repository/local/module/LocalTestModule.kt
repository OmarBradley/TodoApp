package omarbradley.com.repository.local.module

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import omarbradley.com.repository.TodoRepository
import omarbradley.com.repository.local.db.TodoAppDatabase
import omarbradley.com.repository.local.repository.LocalTodoRepository
import org.koin.dsl.module

val localTestModule = module {

    single { LocalTodoRepository(get()) as TodoRepository }
    single { get<TodoAppDatabase>().todoDao() }
    factory {
        Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), TodoAppDatabase::class.java)
            .build()
    }
}
