package com.shankhanilsaha.phonebook.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shankhanilsaha.phonebook.database.Tasks
import java.nio.file.WatchEvent

@Composable
fun Task(task: Tasks,onClick : () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(16.dp))
        .border(
            width = 1.dp,
            color = Color.Black
        ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Column(Modifier.weight(3f)) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Task Name")
                Text(text = "Due Data")
                Text(text = "Duration")
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                Text(text = task.taskName.toString())
                Text(text = task.dueDate.toString())
                Text(text = task.duration.toString())
            }
        }
        IconButton(onClick = { onClick() }, modifier = Modifier.weight(1f)) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                Modifier.padding(8.dp)
            )
        }
    }
}