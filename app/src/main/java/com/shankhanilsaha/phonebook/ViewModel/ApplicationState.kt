package com.shankhanilsaha.phonebook.ViewModel

import com.shankhanilsaha.phonebook.database.Tasks

data class ApplicationState (
    var taskList : List<Tasks> = emptyList(),
    var isAddingTask : Boolean = false
)