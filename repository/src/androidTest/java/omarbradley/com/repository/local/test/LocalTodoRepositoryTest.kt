package omarbradley.com.repository.local.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import kotlinx.coroutines.runBlocking
import omarbradley.com.repository.TodoRepository
import omarbradley.com.repository.local.db.TodoAppDatabase
import omarbradley.com.repository.local.dummy.*
import omarbradley.com.repository.local.module.localTestModule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4::class)
class LocalTodoRepositoryTest : KoinTest {

    private val localTodoRepository: TodoRepository by inject()
    private val todoAppDatabase: TodoAppDatabase by inject()

    @Before
    fun createDb() {
        startKoin { modules(localTestModule) }
    }

    @After
    fun closeDb() {
        todoAppDatabase.close()
        stopKoin()
    }

    @Test
    fun getTodosCountTest() = runBlocking {
        // given : 하나의 투두 객체를 삽입 한다
        localTodoRepository.postTodo(dummyTodo)

        // when : 모든 투두의 갯수를 가져올 시
        val todosCount = localTodoRepository.getTodosCount()

        // then : 모든 투두의 갯수는 1개이다
        assertThat(todosCount, equalTo(1))
    }

    @Test
    fun getTodosCountBy_isCompleted_Test() = runBlocking {
        // given
        localTodoRepository.postTodos(dummyTodos)

        // when
        val isCompletedTodosCount = localTodoRepository.getTodosCountBy(true)

        // then
        assertThat(isCompletedTodosCount, equalTo(isCompletedDummyTodosCount))
    }

    @Test
    fun putTodosTest() = runBlocking {
        // given
        localTodoRepository.postTodos(dummyTodoUsingPutsTest)
        val todos = localTodoRepository.getTodos()
        todos.forEach { it.isCompleted = true }

        // when
        localTodoRepository.putTodos(todos)

        // then
        val isCompletedTodosCount = localTodoRepository.getTodosCountBy(true)
        assertThat(isCompletedTodosCount, equalTo(2))
    }

    @Test
    fun deleteTodos_allTodosDelete_Test() = runBlocking {
        // given
        localTodoRepository.postTodos(dummyTodoUsingDeleteTodos_allTodosDelete_Test)
        val allTodos = localTodoRepository.getTodos()

        // when
        localTodoRepository.deleteTodos(allTodos)

        // then
        val todosCount = localTodoRepository.getTodosCount()
        assertThat(todosCount, equalTo(0))
    }

    @Test
    fun deleteTodos__isCompleted_Test() = runBlocking {
        // scenario1 : 사용자가 하나의 완료되지 않은 투두를 생성
        localTodoRepository.postTodo(dummyIsNotCompletedTodo)

        // scenario2 : 해당 투두에 isCompleted를 true로 하고, 이를 업데이트 한다
        val todo = localTodoRepository.getTodosBy(false).first()
        todo.isCompleted = true
        localTodoRepository.putTodo(todo)

        // given : 완료된 1개의 투두가 주어졌을 때
        val isCompletedTodo = localTodoRepository.getTodosBy(true).first()

        // when : 이를 삭제 시
        localTodoRepository.deleteTodo(isCompletedTodo)

        // then : 남아있는 투두는 0개가 된다
        val todosCount = localTodoRepository.getTodosCount()
        assertThat(todosCount, equalTo(0))
    }

}
