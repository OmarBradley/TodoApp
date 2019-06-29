package omarbradley.com.util.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<MODEL> {

    @Insert
    fun insert(vararg model: MODEL)

    @Update
    fun update(vararg model: MODEL)

    @Delete
    fun delete(vararg model: MODEL)

}
