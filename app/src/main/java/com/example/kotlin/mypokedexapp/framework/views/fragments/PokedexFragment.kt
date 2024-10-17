package com.example.kotlin.mypokedexapp.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.mypokedexapp.R
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.databinding.FragmentPokedexBinding
import com.example.kotlin.mypokedexapp.framework.adapters.PokemonAdapter
import com.example.kotlin.mypokedexapp.framework.viewmodel.PokedexViewModel

class PokedexFragment: Fragment() {
    private var _binding: FragmentPokedexBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: PokedexViewModel

    private lateinit var recyclerView: RecyclerView
    private val adapter : PokemonAdapter = PokemonAdapter()
    private lateinit var data:ArrayList<PokemonBase>

    // Carga estado inicial del fragmento
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inicializar ViewModel
        viewModel = ViewModelProvider(this)[PokedexViewModel::class.java]

        // Inicializar binding
        _binding = FragmentPokedexBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inicializar arreglo de datos
        data = ArrayList()

        initializeComponents(root)      // Inicializa Recycler View
        initializeObservers()
        viewModel.getPokemonList()

        return root
    }

    // Borra referencia a binding --> Libera recursos
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents(root:View){
        // Recibe id del recycler view
            // R --> carpeta res
        recyclerView = root.findViewById(R.id.RVPokemon)
    }

    private fun initializeObservers() {
        viewModel.pokedexObjectLiveData.observe(viewLifecycleOwner) { poxedexObject ->
            setUpRecyclerView(poxedexObject.results)
        }
    }

    private fun setUpRecyclerView(dataForList:ArrayList<PokemonBase>){
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false)
        recyclerView.layoutManager = linearLayoutManager
        adapter.PokemonAdapter(dataForList,requireContext())
        recyclerView.adapter = adapter
    }
}