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

    private val _batiment = MutableStateFlow<Batiment?>(null)
    val batiment: StateFlow<Batiment?> = _batiment

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

    fun getBatiment(batimentId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null  // Réinitialise l'erreur avant l'appel

            try {
                val response = RetrofitInstance.api.getBatiment(batimentId)
                _batiment.value = response.body()
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement du batiment terminé")
            }
        }
    }

    fun addBatiment(batiment: Batiment) {
        viewModelScope.launch {
            _isLoading.value = true
            try {

                // Envoi à l'API (ici, un POST)
                val response = RetrofitInstance.api.addBatiment(batiment)
                if (response.isSuccessful) {
                    // Ajout réussi, on met à jour la liste des bâtiments
                    getBatiments() // Recharge les bâtiments pour inclure le nouveau
                } else {
                    _errorMessage.value = "Erreur lors de l'ajout du bâtiment : ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }


}
