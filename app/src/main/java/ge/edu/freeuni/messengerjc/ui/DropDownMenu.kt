package ge.edu.freeuni.messengerjc.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun DropdownMenuButton() {
    var showMenu by remember { mutableStateOf(false) }
    IconButton(onClick = { showMenu = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = "More")
    }

    androidx.compose.material3.DropdownMenu(
        expanded = showMenu,
        onDismissRequest = { showMenu = false }
    ) {
        DropdownMenuItem(
            onClick = { showMenu = false },
            text = { Text("Share") },
            leadingIcon = { Icon(Icons.Default.Share, contentDescription = "Share") }
        )
        DropdownMenuItem(
            onClick = { showMenu = false },
            text = { Text("Flag as inappropriate") },
            leadingIcon = {
                Icon(
                    Icons.Default.Warning,
                    contentDescription = "Flag as inappropriate"
                )
            }
        )
        var autoUpdateEnabled by remember { mutableStateOf(true) }
        DropdownMenuItem(
            onClick = {
                autoUpdateEnabled = !autoUpdateEnabled
                showMenu = false
            },
            text = { Text("Enable auto-update") },
            leadingIcon = {
                Checkbox(
                    checked = autoUpdateEnabled,
                    onCheckedChange = null
                )
            }
        )
    }
}