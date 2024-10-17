package com.example.kotlin.mypokedexapp.framework.views.activities

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.mypokedexapp.R
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.framework.adapters.PokemonAdapter
import com.example.kotlin.mypokedexapp.databinding.ActivityMainBinding
import com.example.kotlin.mypokedexapp.framework.viewmodel.MainViewModel
import com.example.kotlin.mypokedexapp.framework.views.fragments.PokedexFragment
import com.example.kotlin.mypokedexapp.framework.views.fragments.SearchFragment
import com.example.kotlin.mypokedexapp.util.Constants

class MainActivity: AppCompatActivity() {

    // Variable privada mutable no inicializada -> binding
    private lateinit var binding: ActivityMainBinding

    private lateinit var currentFragment: Fragment
    private var currentMenuOption:String?= null

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        initializeListeners()
        exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)
    }

    // Proporciona forma direct de trabajar con vistas --> No manual
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // CARGAR LOS FRAGMENTOS
    private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption:String){
        // 1. Iniciar objeto de nuevo fragmento
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main,currentFragment)
            .commit()

        currentMenuOption = newMenuOption
    }

    private fun selectMenuOption(menuOption:String){
        if(menuOption == currentMenuOption){
            return
        }

        when(menuOption){
            Constants.MENU_POKEDEX -> exchangeCurrentFragment(PokedexFragment(),Constants.MENU_POKEDEX)
            Constants.MENU_SEARCH -> exchangeCurrentFragment(SearchFragment(),Constants.MENU_SEARCH)
        }
    }

    private fun initializeObservers() {

    }

    private fun initializeListeners() {
        // llPokedex --> id
        binding.appBarMain.findViewById<LinearLayout>(R.id.llPokedex).setOnClickListener {
            selectMenuOption(Constants.MENU_POKEDEX)
        }

        binding.appBarMain.findViewById<LinearLayout>(R.id.llSearch).setOnClickListener {
            selectMenuOption(Constants.MENU_SEARCH)
        }


    }
}