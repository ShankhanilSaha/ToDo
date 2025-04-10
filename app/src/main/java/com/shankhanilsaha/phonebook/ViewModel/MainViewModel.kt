package com.shankhanilsaha.phonebook.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shankhanilsaha.phonebook.database.Tasks
import com.shankhanilsaha.phonebook.database.tasksDatabase
import kotlinx.coroutines.launch


class MainViewModel(val database: tasksDatabase) : ViewModel() {

    init {
        getTasks()
    }

    private val _tasksState = mutableStateOf(ApplicationState())
    val tasksState : State<ApplicationState> = _tasksState
    fun addTask() {
        _tasksState.value = _tasksState.value.copy(
            isAddingTask = true
        )
    }
    fun confirmAddTask(task: Tasks) {
        viewModelScope.launch {
            database.tasksDao().addTask(task)
            getTasks()
        }
        _tasksState.value = _tasksState.value.copy(
            isAddingTask = false
        )
    }
    fun getTasks() {
        viewModelScope.launch {
            var list : List<Tasks> = database.tasksDao().getTasks()
            _tasksState.value = _tasksState.value.copy(
                taskList = list
            )
        }
    }
}