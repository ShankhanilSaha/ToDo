package com.shankhanilsaha.phonebook.viewModel

import com.shankhanilsaha.phonebook.database.Tasks

data class ApplicationState (
    var taskList : List<Tasks> = emptyList(),
    var isAddingTask : Boolean = false
)