package com.example.azurimmo.views.reparation

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
import com.example.azurimmo.views.reparation.ReparationCard
import com.example.azurimmo.viewsmodel.reparation.ReparationViewModel

@Composable
fun ReparationList(viewModel: ReparationViewModel = viewModel()) {
    // Observer les données de manière réactive
    val reparations by viewModel.reparations.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    when {
        isLoading -> CircularProgressIndicator()
        errorMessage != null -> Text(text = errorMessage!!, color = Color.Red)
        else -> LazyColumn {
            items(reparations) { reparation ->
                ReparationCard(reparation = reparation)
            }
        }
    }
}