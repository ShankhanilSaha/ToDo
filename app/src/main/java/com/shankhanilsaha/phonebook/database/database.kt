package com.shankhanilsaha.phonebook.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Tasks::class],version = 1)
abstract class tasksDatabase : RoomDatabase() {
    abstract fun tasksDao() : TasksDAO
}