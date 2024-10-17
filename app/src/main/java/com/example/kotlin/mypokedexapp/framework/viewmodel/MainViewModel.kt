package com.example.kotlin.mypokedexapp.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.mypokedexapp.data.network.model.PokedexObject
import com.example.kotlin.mypokedexapp.data.PokemonRepository
import com.example.kotlin.mypokedexapp.domain.PokemonListRequirement
import com.example.kotlin.mypokedexapp.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
}