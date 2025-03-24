package com.example.azurimmo.model

import java.time.LocalDate

data class Reparation(
    val id: Int,
    val dateReparation: LocalDate,
    val description: String,
    val type: String,
    val societe: String,
    val appartement: Appartement
)
