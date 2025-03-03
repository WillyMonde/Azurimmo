package com.example.azurimmo.viewsmodel.batiment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.azurimmo.model.Batiment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BatimentViewModel : ViewModel() {

    // Liste mutable des bâtiments
    private val _batiments = MutableStateFlow<List<Batiment>>(emptyList())
    val batiments: StateFlow<List<Batiment>> = _batiments

    init {
        // Simuler un chargement de données initiales
        getBatiments()
    }

    // Fonction pour simuler le chargement de bâtiments
    private fun getBatiments() {
        viewModelScope.launch {
            _batiments.value = listOf(
                Batiment(1, "123 Rue Principale", "Nice"),
                Batiment(2, "456 Avenue des Champs", "Marseille"),
                Batiment(3, "789 Boulevard Haussmann", "Marseille")
            )
        }
    }
}
