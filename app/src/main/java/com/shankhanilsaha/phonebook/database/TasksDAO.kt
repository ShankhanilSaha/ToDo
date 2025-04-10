package com.shankhanilsaha.phonebook.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TasksDAO {
    @Insert
    suspend fun addTask(task : Tasks)
    @Delete
    suspend fun deleteTask(task : Tasks)
    @Query("SELECT * FROM tasks")
    suspend fun getTasks() : List<Tasks>
 }