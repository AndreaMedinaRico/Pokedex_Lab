package com.example.kotlin.mypokedexapp.data

import com.example.kotlin.mypokedexapp.data.network.NetworkModuleID
import com.example.kotlin.mypokedexapp.data.network.model.PokedexObject
import com.example.kotlin.mypokedexapp.data.network.PokemonAPIService
import com.example.kotlin.mypokedexapp.data.network.PokemonApiClient
import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon

// El repositorio SOLO se encarga de hacer las llamadas necesarias

class PokemonRepository() {
    private val apiPokemon = PokemonApiClient()

    suspend fun getPokemonList(limit:Int): PokedexObject? = apiPokemon.getPokemonList(limit)

    suspend fun getPokemonInfo(numberPokemon:Int): Pokemon?  = apiPokemon.getPokemonInfo(numberPokemon)
}