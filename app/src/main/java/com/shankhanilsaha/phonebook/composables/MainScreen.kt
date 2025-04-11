package com.shankhanilsaha.phonebook.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shankhanilsaha.phonebook.database.Tasks
import com.shankhanilsaha.phonebook.viewModel.MainViewModel

@Composable
fun MainScreen(modifier: Modifier, viewModel: MainViewModel) {

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Tasks",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold)
        LazyColumn {
            items(viewModel.tasksState.value.taskList) {
                Task(task = it, onClick = {
                    viewModel.deleteTask(it)
                })
            }
        }
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    viewModel.addTaskList()
                }, containerColor = Color.Cyan) {
                    Icon(imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.Black)
                }
            },
            floatingActionButtonPosition = FabPosition.End
        ) { innerPadding ->
            if (viewModel.tasksState.value.isAddingTask) {
                val newTask = remember { mutableStateOf(Tasks(0, "", "", "")) }

                AlertDialog(
                    modifier = Modifier.padding(innerPadding),
                    onDismissRequest = {
                        viewModel.stopAdding()
                        newTask.value = Tasks(0, "", "", "") // Reset the form
                    },
                    confirmButton = {
                        Button(onClick = {
                            viewModel.confirmAddTask(newTask.value)
                            newTask.value = Tasks(0, "", "", "") // Reset the form after adding
                        }) {
                            Text(text = "Add")
                        }
                    },
                    title = { Text(text = "Add Task") },
                    text = {
                        Column {
                            OutlinedTextField(
                                value = newTask.value.taskName,
                                onValueChange = { input ->
                                    newTask.value = newTask.value.copy(taskName = input)
                                },
                                label = { Text(text = "Enter task name") }
                            )
                            OutlinedTextField(
                                value = newTask.value.dueDate,
                                onValueChange = { input ->
                                    newTask.value = newTask.value.copy(dueDate = input)
                                },
                                label = { Text(text = "Enter due date") }
                            )
                            OutlinedTextField(
                                value = newTask.value.duration,
                                onValueChange = { input ->
                                    newTask.value = newTask.value.copy(duration = input)
                                },
                                label = { Text(text = "Enter duration") }
                            )
                        }
                    }
                )
            }
        }
    }
}

