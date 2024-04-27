package ge.edu.freeuni.messengerjc.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DataSafetyCard(onSeeDetailsClicked: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = defaultModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { expanded = !expanded },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Data safety", style = MaterialTheme.typography.headlineSmall)
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }
            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
                    Text(
                        text = "Safety starts with understanding how developers collect and share your data. " +
                                "Data privacy and security practices may vary based on your use, region, and age. " +
                                "The developer provided this information and may update it over time.",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    SafetyPoint(
                        icon = Icons.Default.Share,
                        text = "This app may share these data types with third parties",
                        detail = "Personal info and Device or other IDs"
                    )
                    SafetyPoint(
                        icon = Icons.Default.Info,
                        text = "This app may collect these data types",
                        detail = "Location, Personal info and 12 others"
                    )
                    SafetyPoint(icon = Icons.Default.Lock, text = "Data is encrypted in transit")
                    SafetyPoint(
                        icon = Icons.Default.Delete,
                        text = "You can request that data be deleted"
                    )

                    Text(
                        text = "Learn more",
                        style = MaterialTheme.typography.labelSmall.copy(color = Color(0xFF6200EE)),
                        modifier = Modifier.clickable(onClick = onSeeDetailsClicked)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun SafetyPoint(icon: ImageVector, text: String, detail: String? = null) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null)
        Spacer(Modifier.width(8.dp))
        Column {
            Text(text, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelSmall)
            detail?.let {
                Text(it, style = MaterialTheme.typography.labelSmall)
            }
        }
    }
    Spacer(Modifier.height(8.dp))
}
