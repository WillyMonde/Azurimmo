package com.example.azurimmo.viewsmodel.appartement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.azurimmo.model.Appartement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppartementViewModel : ViewModel() {

    // Liste mutable des bâtiments
    private val _appartements = MutableStateFlow<List<Appartement>>(emptyList())
    val appartements: StateFlow<List<Appartement>> = _appartements

    init {
        // Simuler un chargement de données initiales
        getAppartements()
    }

    // Fonction pour simuler le chargement de bâtiments
    private fun getAppartements() {
        viewModelScope.launch {
            _appartements.value = listOf(
                Appartement(1, "AEA514", 25.5F, 3, "Appartement étudiant"),
                Appartement(2, "55A1SA", 50.5F, 12,"Appartement vue sur la mer"),
                Appartement(3, "7544Q3", 122.3F, 8,"Maison 3 étages")
            )
        }
    }
}
