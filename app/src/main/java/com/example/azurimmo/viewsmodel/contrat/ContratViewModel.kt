package com.example.azurimmo.viewsmodel.contrat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.azurimmo.model.Contrat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class ContratViewModel : ViewModel() {

    private val _contrats = MutableStateFlow<List<Contrat>>(emptyList())
    val contrats: StateFlow<List<Contrat>> = _contrats

    init {
        getContrats()
    }

    private fun getContrats() {
        viewModelScope.launch {
            _contrats.value = listOf(
                Contrat(1, 1, 1, LocalDate.of(2023, 1, 1), null, 750f),
                Contrat(2, 2, 2, LocalDate.of(2022, 6, 15), LocalDate.of(2023, 6, 14), 950f)
            )
        }
    }
}
