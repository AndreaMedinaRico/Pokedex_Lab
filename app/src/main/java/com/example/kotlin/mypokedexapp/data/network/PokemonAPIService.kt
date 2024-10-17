package com.example.kotlin.mypokedexapp.data.network

import com.example.kotlin.mypokedexapp.data.network.model.PokedexObject
import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPIService {
    /*
    * URL mapeada:
    * https://pokeapi.co/api/v2/pokemon/?limit=1279
    */
    @GET("pokemon")                     // Tipo de llamada y ruta a seguir
    suspend fun getPokemonList(         // Función asíncrona
        @Query("limit") limit:Int       // Indica parámetro que se agregará al URL --> Query
    ): com.example.kotlin.mypokedexapp.data.network.model.PokedexObject                    // Tipo de dato regresado

    /*
    * https://pokeapi.co/api/v2/pokemon/{number_pokemon}/
    * Llamada GET a pokemon que recibe el num de Poemon y regresa OBJETO POKEMON
    * */
    @GET("pokemon/{numberPokemon}")
    suspend fun getPokemonInfo(
        @Path("numberPokemon") numberPokemon:Int
    ) : com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon
}