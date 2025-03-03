package com.example.azurimmo.views.paiement

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
import com.example.azurimmo.model.Paiement

@Composable
fun PaiementCard(paiement: Paiement) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Paiement #${paiement.id}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Contrat: ${paiement.contratId}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Date: ${paiement.datePaiement}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Montant: ${paiement.montant} €", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
