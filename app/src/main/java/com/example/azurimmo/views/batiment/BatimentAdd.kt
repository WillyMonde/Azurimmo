package com.example.azurimmo.views.batiment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.azurimmo.model.Batiment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.azurimmo.viewsmodel.batiment.BatimentViewModel


@Composable
fun BatimentAdd(navController: NavController) {
    val viewModel: BatimentViewModel = viewModel()
    val adresse = remember { mutableStateOf("") }
    val ville = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        OutlinedTextField(
            value = adresse.value,
            onValueChange = { adresse.value = it },
            label = { Text("Adresse") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = ville.value,
            onValueChange = { ville.value = it },
            label = { Text("Ville") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (adresse.value.isNotBlank() && ville.value.isNotBlank()) {
                    val batiment = Batiment(id = 0, adresse = adresse.value, ville = ville.value)
                    viewModel.addBatiment(batiment)
                    navController.navigate("batiments_list")
                }
            },
            modifier = Modifier.align(Alignment.End),
            enabled = adresse.value.isNotBlank() && ville.value.isNotBlank()
        )
        {
            Text("Ajouter le bâtiment")
        }
    }
}
