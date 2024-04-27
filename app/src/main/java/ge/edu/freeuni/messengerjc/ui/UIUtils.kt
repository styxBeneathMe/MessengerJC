package ge.edu.freeuni.messengerjc.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

val defaultModifier = Modifier
    .fillMaxWidth()
    .padding(8.dp)

data class AppInfo(val logo: Painter, val name: String, val rating: Float)

data class Review(
    val name: String,
    val content: String,
    val date: String,
    val helpfulCount: Int,
    val rating: Float
)