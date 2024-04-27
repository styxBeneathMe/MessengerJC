package ge.edu.freeuni.messengerjc.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextSection(title: String, content: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        Text(text = content)
    }
}

@Composable
fun RefundPolicy(policy: String) {
    Card(
        modifier = defaultModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        TextSection(title = "Google Play refund policy", content = policy)
    }
}