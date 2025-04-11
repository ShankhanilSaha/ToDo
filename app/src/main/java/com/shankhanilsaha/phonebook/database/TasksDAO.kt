package com.shankhanilsaha.phonebook.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDAO {
    @Insert
    suspend fun addTask(task: Tasks)

    @Delete
    suspend fun deleteTask(task: Tasks)

    @Query("SELECT * FROM tasks")
    fun getTasks(): Flow<List<Tasks>>
}