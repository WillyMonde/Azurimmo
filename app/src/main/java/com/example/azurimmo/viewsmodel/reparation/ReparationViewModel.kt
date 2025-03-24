package com.example.azurimmo.viewsmodel.reparation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.azurimmo.api.RetrofitInstance
import com.example.azurimmo.model.Reparation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class ReparationViewModel : ViewModel() {

    private val _reparations = MutableStateFlow<List<Reparation>>(emptyList())
    val reparations: StateFlow<List<Reparation>> = _reparations

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getReparations()
    }

    private fun getReparations() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null  // Réinitialise l'erreur avant l'appel

            try {
                val response = RetrofitInstance.api.getReparations()
                _reparations.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est 		produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }
}