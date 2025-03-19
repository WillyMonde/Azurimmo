package com.example.azurimmo.viewsmodel.locataire

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.azurimmo.api.RetrofitInstance
import com.example.azurimmo.model.Locataire
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocataireViewModel : ViewModel() {

    private val _locataires = MutableStateFlow<List<Locataire>>(emptyList())
    val locataires: StateFlow<List<Locataire>> = _locataires

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getLocataires()
    }

    private fun getLocataires() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null  // Réinitialise l'erreur avant l'appel

            try {
                val response = RetrofitInstance.api.getLocataires()
                _locataires.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est 		produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }
}
