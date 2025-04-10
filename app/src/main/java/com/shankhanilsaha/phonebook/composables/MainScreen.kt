package com.shankhanilsaha.phonebook.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.shankhanilsaha.phonebook.database.Tasks
import com.shankhanilsaha.phonebook.ViewModel.MainViewModel
import com.shankhanilsaha.phonebook.database.tasksDatabase

@Composable
fun MainScreen(modifier: Modifier, viewModel: MainViewModel, database : tasksDatabase) {

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Tasks")
    }
    LazyColumn {
        items(viewModel.tasksState.value.taskList) {
            Task(task = it)
        }
    }
    FloatingActionButton(onClick = {
        viewModel.addTask()
    }, containerColor = Color.Cyan) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }

    if (viewModel.tasksState.value.isAddingTask) {
        var newTask = remember {mutableStateOf(Tasks(0,"","",""))}
        AlertDialog(
            onDismissRequest = {viewModel.tasksState.value.isAddingTask = false},
            confirmButton = {
                Button(onClick = {
                    viewModel.confirmAddTask(newTask.value)
                }) {
                    Text(text = "Add")
                }
            },
            title = { Text(text = "Add Task") },
            text = {
                OutlinedTextField(
                    value = newTask.value.taskName,
                    onValueChange = { input -> newTask.value.taskName = input },
                    label = { Text(text = "Enter task name") }
                )
                OutlinedTextField(
                    value = newTask.value.dueDate,
                    onValueChange = { input -> newTask.value.dueDate = input },
                    label = { Text(text = "Enter due date") }
                )
                OutlinedTextField(
                    value = newTask.value.duration,
                    onValueChange = { input -> newTask.value.duration = input },
                    label = { Text(text = "Enter duration") }
                )
            }
        )
    }
}

