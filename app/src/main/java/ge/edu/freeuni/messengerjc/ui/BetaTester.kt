package ge.edu.freeuni.messengerjc.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun BetaTesterCard(email: String, onLearnMoreClicked: () -> Unit) {
    Card(
        modifier = defaultModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Switch accounts to become a beta tester",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "This app is associated with a different account, $email. " +
                        "To get beta updates for this app, first switch to that account in " +
                        "Play Store and join the beta.",
                style = MaterialTheme.typography.labelSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Learn more",
                style = MaterialTheme.typography.labelSmall.copy(color = Color(0xFF6200EE)),
                modifier = Modifier.clickable(onClick = onLearnMoreClicked)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
