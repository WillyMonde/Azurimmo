package com.example.azurimmo.api

import com.example.azurimmo.model.Batiment
import com.example.azurimmo.model.Appartement
import com.example.azurimmo.model.Locataire
import com.example.azurimmo.model.Contrat
import com.example.azurimmo.model.Paiement

import retrofit2.http.GET

interface ApiService {

    @GET("/batiments")
    suspend fun getBatiments(): List<Batiment>

    @GET("/appartements")
    suspend fun getAppartements(): List<Appartement>

    @GET("/locataires")
    suspend fun getLocataires(): List<Locataire>

    @GET("/contrats")
    suspend fun getContrats(): List<Contrat>

    @GET("/paiements")
    suspend fun getPaiements(): List<Paiement>
}