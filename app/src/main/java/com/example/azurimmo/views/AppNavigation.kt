package com.example.azurimmo.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import com.example.azurimmo.views.batiment.BatimentList

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
            Text("Page appartements")
        }
        composable("contrats_list") {
            Text("Page contrats")
        }
        composable("locataires_list") {
            Text("Page locataires")
        }
        composable("paiements_list") {
            Text("Page paiements")
        }
    }
}