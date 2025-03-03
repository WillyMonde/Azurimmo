package com.example.azurimmo.views.appartement

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.azurimmo.viewsmodel.appartement.AppartementViewModel

@Composable
fun AppartementList(viewModel: AppartementViewModel = viewModel()) {

    val appartements by viewModel.appartements.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(appartements) { appartement ->
            AppartementCard(appartement = appartement)
        }
    }
}