package com.example.azurimmo.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import com.example.azurimmo.views.appartement.AppartementList
import com.example.azurimmo.views.batiment.BatimentAdd
import com.example.azurimmo.views.batiment.BatimentList
import com.example.azurimmo.views.contrat.ContratList
import com.example.azurimmo.views.locataire.LocataireList
import com.example.azurimmo.views.paiement.PaiementList
import com.example.azurimmo.views.reparation.ReparationList


@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "batiments_list",
        modifier = modifier
    ) {
        composable("batiments_list") {
            // Passer la navigation et la logique d'ajout de bâtiment
            BatimentList(
                navController = navController,
                onBatimentClick = { batimentId ->
                    navController.navigate("appartements_list/$batimentId")
                },
                onAddBatimentClick = {
                    navController.navigate("add_batiment")
                }
            )
        }

        composable("add_batiment") {
            BatimentAdd(navController = navController)
        }

        // Route pour afficher les appartements associés à un bâtiment
        composable("appartements_list?batimentId={batimentId}") { backStackEntry ->
            val batimentId = backStackEntry.arguments?.getString("batimentId")?.toIntOrNull()
            AppartementList(batimentId = batimentId)
        }

        // D'autres destinations comme Contrat, Locataire, Paiement
        composable("contrats_list") {
            ContratList()
        }
        composable("locataires_list") {
            LocataireList()
        }
        composable("paiements_list") {
            PaiementList()
        }

        composable("reparations_list") {
            ReparationList()
        }

    }
}
