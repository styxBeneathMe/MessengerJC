package ge.edu.freeuni.messengerjc.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RatingsAndReviewsCard(reviews: List<Review>, onSeeAllClicked: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = defaultModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
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
                Text("Ratings and reviews", style = MaterialTheme.typography.headlineSmall)
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }
            AnimatedVisibility(visible = expanded) {
                Column {
                    Text("4.3", style = MaterialTheme.typography.labelSmall)
                    Text("13,326,423 ratings", style = MaterialTheme.typography.labelSmall)
                    val maxCount = 5000f
                    for (i in 5 downTo 1) {
                        RatingsBar(
                            rating = i,
                            count = (1..5000).random().toFloat(),
                            maxCount = maxCount,
                        )
                    }
                    reviews.forEach { review ->
                        ReviewItem(review = review)
                    }
                    Text(
                        text = "See all reviews",
                        style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF6200EE)),
                        modifier = Modifier.clickable(onClick = onSeeAllClicked)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun RatingsBar(
    rating: Int,
    count: Float,
    maxCount: Float,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("$rating", style = MaterialTheme.typography.labelSmall)
        LinearProgressIndicator(
            progress = count / maxCount,
            modifier = Modifier
                .weight(1f)
                .height(8.dp)
                .padding(horizontal = 8.dp),
            trackColor = Color.LightGray,
            color = Color.Blue
        )
    }
}


@Composable
fun ReviewItem(review: Review) {
    Card(
        modifier = defaultModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(review.name, style = MaterialTheme.typography.labelMedium)
                    Text(review.date, style = MaterialTheme.typography.labelSmall)
                    Text(review.content, style = MaterialTheme.typography.labelSmall)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RatingBar(rating = review.rating)
                        Text(
                            "${review.helpfulCount} people found this helpful",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text("Was this review helpful?")
                        Spacer(modifier = Modifier.width(8.dp))
                        OutlinedButton(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            contentPadding = PaddingValues(),
                            modifier = Modifier.defaultMinSize(minWidth = 64.dp, minHeight = 32.dp),
                            border = BorderStroke(1.dp, Color.Gray)
                        ) {
                            Text("Yes", color = Color.Gray, fontSize = 12.sp)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White),
                            contentPadding = PaddingValues(),
                            modifier = Modifier.defaultMinSize(minWidth = 64.dp, minHeight = 32.dp),
                        ) {
                            Text("No", color = Color.Gray, fontSize = 12.sp)
                        }
                    }
                }
                DropdownMenuButton()
            }
        }
    }
}

@Composable
fun RatingBar(rating: Float, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(vertical = 4.dp)) {
        (1..5).forEach { i ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Rating Star",
                tint = if (i <= rating) Color(0xFFFFD700) else Color(0xFFE0E0E0),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
