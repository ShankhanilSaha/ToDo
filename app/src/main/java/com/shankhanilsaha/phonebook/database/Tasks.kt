package com.shankhanilsaha.phonebook.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    var taskOrder : Int = 0,
    var taskName: String,
    var dueDate : String,
    var duration : String
)
