package ge.edu.freeuni.messengerjc.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AboutThisAppCard(
    appDescription: String,
    categoryChips: List<String>,
    reviewCount: String,
    reviewStars: Float,
    downloadSize: String,
    ageRating: String,
    downloadCount: String,
    screenshots: List<ImageBitmap>
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = defaultModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("About this app", style = MaterialTheme.typography.headlineSmall)
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }
            AnimatedVisibility(visible = expanded) {
                Column {
                    Text(
                        text = appDescription,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(16.dp)
                    )
                    CategoryChips(categories = categoryChips)
                    StatsRow(
                        reviewCount = reviewCount,
                        reviewStars = reviewStars,
                        downloadSize = downloadSize,
                        ageRating = ageRating,
                        downloadCount = downloadCount
                    )
                    ScreenshotsCarousel(screenshots = screenshots)
                }
            }
        }
    }
}

@Composable
fun StatsRow(
    reviewCount: String,
    reviewStars: Float,
    downloadSize: String,
    ageRating: String,
    downloadCount: String
) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        StatItem(label = "$reviewStars★", value = "$reviewCount reviews")
        Spacer(modifier = Modifier.width(25.dp))
        StatItem(label = "Size", value = downloadSize)
        Spacer(modifier = Modifier.width(25.dp))
        StatItem(label = "Age", value = ageRating)
        Spacer(modifier = Modifier.width(25.dp))
        StatItem(label = "Downloads", value = downloadCount)
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, fontWeight = FontWeight.Bold)
        Text(text = label)
    }
}


@Composable
fun CategoryChips(categories: List<String>) {
    Card(
        modifier = defaultModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            categories.forEach { category ->
                Chip(label = category)
            }
        }
    }
}

@Composable
fun Chip(label: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(50))
            .clickable {}
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(label)
    }
}

@Composable
fun ScreenshotsCarousel(screenshots: List<ImageBitmap>) {
    LazyRow {
        items(screenshots) { screenshot ->
            Image(
                bitmap = screenshot, contentDescription = "Screenshot", modifier = Modifier
                    .padding(4.dp)
                    .height(200.dp)
            )
        }
    }
}
