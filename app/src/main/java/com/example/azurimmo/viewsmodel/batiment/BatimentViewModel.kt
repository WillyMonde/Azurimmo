package com.example.azurimmo.viewsmodel.batiment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.azurimmo.model.Batiment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import com.example.azurimmo.api.RetrofitInstance
import kotlinx.coroutines.launch

class BatimentViewModel : ViewModel() {

    // Liste mutable des bâtiments
    private val _batiments = MutableStateFlow<List<Batiment>>(emptyList())
    val batiments: StateFlow<List<Batiment>> = _batiments

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getBatiments()
    }


    private fun getBatiments() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null  // Réinitialise l'erreur avant l'appel

            try {
                val response = RetrofitInstance.api.getBatiments()
                _batiments.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est 		produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }


}
