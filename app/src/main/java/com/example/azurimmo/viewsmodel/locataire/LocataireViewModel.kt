package com.example.azurimmo.viewsmodel.locataire

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.azurimmo.model.Locataire
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocataireViewModel : ViewModel() {

    private val _locataires = MutableStateFlow<List<Locataire>>(emptyList())
    val locataires: StateFlow<List<Locataire>> = _locataires

    init {
        getLocataires()
    }

    private fun getLocataires() {
        viewModelScope.launch {
            _locataires.value = listOf(
                Locataire(1, "Dupont", "Jean", "0601020304", "jean.dupont@mail.com"),
                Locataire(2, "Martin", "Claire", "0605060708", "claire.martin@mail.com"),
                Locataire(3, "Durand", "Luc", "0611121314", "luc.durand@mail.com")
            )
        }
    }
}
