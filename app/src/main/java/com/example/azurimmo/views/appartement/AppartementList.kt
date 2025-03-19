package com.example.azurimmo.views.appartement

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.azurimmo.views.batiment.BatimentCard
import com.example.azurimmo.viewsmodel.appartement.AppartementViewModel
import com.example.azurimmo.viewsmodel.batiment.BatimentViewModel


@Composable
fun AppartementList(viewModel: AppartementViewModel = viewModel()) {
    // Observer les données de manière réactive
    val appartements by viewModel.appartements.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    when {
        isLoading -> CircularProgressIndicator()
        errorMessage != null -> Text(text = errorMessage!!, color = Color.Red)
        else -> LazyColumn {
            items(appartements) { appartement ->
                AppartementCard(appartement = appartement)
            }
        }
    }
}