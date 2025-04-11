package com.shankhanilsaha.phonebook.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shankhanilsaha.phonebook.database.Tasks
import com.shankhanilsaha.phonebook.database.tasksDatabase
import kotlinx.coroutines.launch


class MainViewModel(val database: tasksDatabase) : ViewModel() {

    init {
        getTasksList()
    }

    private val _tasksState = mutableStateOf(ApplicationState())
    val tasksState : State<ApplicationState> = _tasksState
    fun addTaskList() {
        _tasksState.value = _tasksState.value.copy(
            isAddingTask = true
        )
    }
    fun confirmAddTask(task: Tasks) {
        viewModelScope.launch {
            database.tasksDao().addTask(task)
            _tasksState.value = _tasksState.value.copy(
                isAddingTask = false
            )
        }
    }
    fun getTasksList() {
        viewModelScope.launch {
            database.tasksDao().getTasks().collect {
                list ->
                _tasksState.value = _tasksState.value.copy(
                    taskList = list
                )
            }
        }
    }

    fun stopAdding() {
        _tasksState.value = _tasksState.value.copy(
            isAddingTask = false
        )
    }

    fun deleteTask(tasks: Tasks) {
        viewModelScope.launch {
            database.tasksDao().deleteTask(tasks)
        }
    }
}
