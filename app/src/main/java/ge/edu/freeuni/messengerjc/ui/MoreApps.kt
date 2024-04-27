package ge.edu.freeuni.messengerjc.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun MoreAppsByDeveloper(apps: List<AppInfo>) {
    Card(
        modifier = defaultModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Text(
                "More by Meta Platforms, Inc.",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
            )
            LazyRow {
                items(apps) { app ->
                    AppBox(appInfo = app)
                }
            }
        }
    }
}

@Composable
fun AppBox(appInfo: AppInfo) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp)) {
        Image(
            painter = appInfo.logo,
            contentDescription = "${appInfo.name} logo",
            modifier = Modifier.size(80.dp)
        )
        Text(appInfo.name, maxLines = 1, overflow = TextOverflow.Ellipsis)
        Row {
            Text("${appInfo.rating}")
            Icon(Icons.Default.Star, contentDescription = "Rating", Modifier.size(16.dp))
        }
    }
}
