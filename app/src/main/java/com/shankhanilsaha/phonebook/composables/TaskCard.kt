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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shankhanilsaha.phonebook.database.Tasks
import java.nio.file.WatchEvent

@Composable
fun Task(task: Tasks,onClick : () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .clip(RoundedCornerShape(1.dp))
        .border(
            width = 1.dp,
            color = Color.White
        ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Column(Modifier.weight(3f)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(4.dp)) {
                Text(text = "Task Name",modifier = Modifier.weight(0.33f))
                Text(text = "Due Data",modifier = Modifier.weight(0.33f))
                Text(text = "Duration",modifier = Modifier.weight(0.33f))
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(4.dp)) {
                Text(text = task.taskName.toString(), maxLines = 1,overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(0.33f))
                Text(text = task.dueDate.toString(), maxLines = 1,overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(0.33f))
                Text(text = task.duration.toString(),  maxLines = 1,overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(0.33f))
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