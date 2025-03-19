package com.example.azurimmo.views.batiment

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.azurimmo.viewsmodel.batiment.BatimentViewModel
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment


@Composable
fun BatimentList(
    viewModel: BatimentViewModel = viewModel(),
    navController: NavController,
    onBatimentClick: (Int) -> Unit, // Cette fonction attend un paramètre Int
    onAddBatimentClick: () -> Unit
) {
    val batiments by viewModel.batiments.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Titre de la liste des bâtiments
            Text(
                text = "Liste des Bâtiments",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Affichage du bouton pour ajouter un bâtiment
            Button(
                onClick = onAddBatimentClick,
                modifier = Modifier
                    .widthIn(min = 150.dp, max = 300.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            ) {
                Text("Ajouter un bâtiment")
            }

            // Affichage du contenu en fonction de l'état de chargement et d'erreur
            when {
                isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                errorMessage != null -> Text(text = errorMessage!!, color = Color.Red, modifier = Modifier.align(Alignment.CenterHorizontally))
                else -> LazyColumn {
                    items(batiments) { batiment ->
                        BatimentCard(batiment = batiment, navController = navController)
                    }
                }
            }
        }
    }
}
