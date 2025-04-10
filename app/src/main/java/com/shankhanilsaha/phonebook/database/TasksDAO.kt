package com.shankhanilsaha.phonebook.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDAO {
    @Insert
    fun addTask(task : Tasks)
    @Delete
    fun deleteTask(task : Tasks)
    @Query("SELECT * FROM tasks")
    fun getTasks() : Flow<List<Tasks>>
}