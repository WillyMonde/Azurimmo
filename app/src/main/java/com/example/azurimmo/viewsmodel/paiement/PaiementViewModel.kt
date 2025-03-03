package com.example.azurimmo.viewsmodel.paiement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.azurimmo.model.Paiement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class PaiementViewModel : ViewModel() {

    private val _paiements = MutableStateFlow<List<Paiement>>(emptyList())
    val paiements: StateFlow<List<Paiement>> = _paiements

    init {
        getPaiements()
    }

    private fun getPaiements() {
        viewModelScope.launch {
            _paiements.value = listOf(
                Paiement(1, 1, LocalDate.of(2024, 1, 5), 142.3),
                Paiement(2, 1, LocalDate.of(2024, 2, 5), 41.4),
                Paiement(3, 2, LocalDate.of(2023, 7, 1), 521.3)
            )
        }
    }
}
