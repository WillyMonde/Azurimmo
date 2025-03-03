package com.example.azurimmo.views.contrat

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.azurimmo.viewsmodel.contrat.ContratViewModel

@Composable
fun ContratList(viewModel: ContratViewModel = viewModel()) {
    val contrats by viewModel.contrats.collectAsState()

    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(contrats) { contrat ->
            ContratCard(contrat = contrat)
        }
    }
}
