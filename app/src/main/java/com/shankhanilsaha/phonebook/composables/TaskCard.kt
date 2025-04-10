package com.shankhanilsaha.phonebook.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shankhanilsaha.phonebook.database.Tasks

@Composable
fun Task(task: Tasks) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(4.dp))
        .border(width = 4.dp,
        color = Color.Black),
        horizontalArrangement = Arrangement.SpaceEvenly)
    {
        Text(text = task.taskName.toString())
        Text(text = task.dueDate.toString())
        Text(text = task.duration.toString())
    }
}