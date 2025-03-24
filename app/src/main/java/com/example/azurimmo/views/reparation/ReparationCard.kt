package com.example.azurimmo.views.reparation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.azurimmo.model.Reparation

@Composable
fun ReparationCard(reparation: Reparation) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Reparation #${reparation.id}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Appartement n° : ${reparation.appartement.numero}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Date: ${reparation.dateReparation}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Société: ${reparation.societe}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Description: ${reparation.description}", style = MaterialTheme.typography.bodyMedium)

        }
    }
}