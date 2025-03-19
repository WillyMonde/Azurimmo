package com.example.azurimmo.views.appartement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.azurimmo.views.batiment.BatimentCard
import com.example.azurimmo.viewsmodel.appartement.AppartementViewModel
import com.example.azurimmo.viewsmodel.batiment.BatimentViewModel


@Composable
fun AppartementList(
    batimentId: Int? = null,  // batimentId devient optionnel
    appartementViewModel: AppartementViewModel = viewModel(),
    batimentViewModel: BatimentViewModel = viewModel()  ) {

    val appartements by appartementViewModel.appartements.collectAsState()
    val isLoading by appartementViewModel.isLoading.collectAsState()
    val errorMessage by appartementViewModel.errorMessage.collectAsState()
    val batiment by batimentViewModel.batiment.collectAsState()



    // récup des données à afficher
    LaunchedEffect(batimentId) {
        if (batimentId == null) {
            appartementViewModel.getAppartements()  // Charge tous les appartements
        } else {
            appartementViewModel.getAppartementsByBatiment(batimentId)
            batimentViewModel.getBatiment(batimentId)// Charge par bâtiment
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            errorMessage != null -> {
                Text(
                    text = errorMessage ?: "Erreur inconnue",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.error
                )
            }
            else -> {


                LazyColumn {

                    // BLOC D'INFOS SUR LE BATIMENT SI SELECTIONNE AVANT
                    if (batiment != null) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally // Centrer le contenu horizontalement
                            ) {
                                Text(
                                    text = "Informations sur le bâtiment",
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Adresse : ${batiment?.adresse ?: "Non défini"}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Ville : ${batiment?.ville ?: "Non défini"}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }

                    // S'il y a des appartements
                    if (appartements.isNotEmpty()) {


                        // Titre Liste des appartements
                        item {
                            Text(
                                text = "Liste des appartements",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 1.dp)
                                    .padding(16.dp),
                                textAlign = TextAlign.Center, // Alignement à gauche
                                color = MaterialTheme.colorScheme.primary
                            )
                        }


                        // Liste des appartements
                        items(appartements) { appartement ->
                            AppartementCard(appartement = appartement)
                        }
                    }

                    else {
                        // Il n'y a pas d'appartement pour ce batiment
                        item {
                            Text(
                                text = "Pas d'appartement pour ce batiment",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 1.dp)
                                    .padding(16.dp),
                                textAlign = TextAlign.Center, // Alignement à gauche
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }

}

