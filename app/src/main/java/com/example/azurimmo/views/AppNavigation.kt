package com.example.azurimmo.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import com.example.azurimmo.views.appartement.AppartementList
import com.example.azurimmo.views.batiment.BatimentList
import com.example.azurimmo.views.contrat.ContratList
import com.example.azurimmo.views.locataire.LocataireList
import com.example.azurimmo.views.paiement.PaiementList

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "batiments_list",
        modifier = modifier
    ) {
        composable("batiments_list") {
            BatimentList()
        }
        composable("appartements_list") {
            AppartementList()
        }
        composable("contrats_list") {
            ContratList()
        }
        composable("locataires_list") {
            LocataireList()
        }
        composable("paiements_list") {
            PaiementList()
        }
    }
}