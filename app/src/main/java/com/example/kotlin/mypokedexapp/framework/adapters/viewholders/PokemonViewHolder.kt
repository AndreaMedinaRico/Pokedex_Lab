package com.example.kotlin.mypokedexapp.framework.adapters.viewholders

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon
import com.example.kotlin.mypokedexapp.databinding.ItemPokemonBinding
import com.example.kotlin.mypokedexapp.domain.PokemonInfoRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Recibe variable binding como atributo       hereda de RecyclerView
class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
    /*
    * FUNCIÓN
    * Une los datos con el layout
    * */

    //val context:Context = (mainActivity as Context)

    fun bind(item: PokemonBase, context: Context){
        binding.TVName.text = item.name
        getPokemonInfo(item.url,binding.IVPhoto,context)
    }

    private fun getPokemonInfo(url:String, imageView: ImageView, context: Context){
        //"https://pokeapi.co/api/v2/pokemon/23/"
        // Obteniendo ID del pokemon
        var pokemonStringNumber:String = url.replace("https://pokeapi.co/api/v2/pokemon/","")
        pokemonStringNumber = pokemonStringNumber.replace("/","")
        val pokemonNumber:Int = Integer.parseInt(pokemonStringNumber)

        // Llamada a API --> Obtiene resultado
        CoroutineScope(Dispatchers.IO).launch {
            val pokemonInfoRequirement = PokemonInfoRequirement()
            val result: Pokemon? = pokemonInfoRequirement(pokemonNumber)

            CoroutineScope(Dispatchers.Main).launch {
                // Obtener URL de imagen
                val urlImage = result?.sprites?.other?.official_artwork?.front_default.toString()

                // Configuración Glide --> Opciones para mostrar imagen
                val requestOptions =  RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(imageView.context)
                    .load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }}
}