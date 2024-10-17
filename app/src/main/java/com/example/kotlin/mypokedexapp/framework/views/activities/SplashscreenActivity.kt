package com.example.kotlin.mypokedexapp.framework.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.kotlin.mypokedexapp.databinding.ActivitySplashscreenBinding
import com.example.kotlin.mypokedexapp.framework.viewmodel.SplashscreenViewModel

class SplashscreenActivity:AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding
    private val viewModel: SplashscreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()

        viewModel.onCreate()

        initializeObservers()
    }

    private fun initializeBinding(){
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){
        viewModel.finishedLoading.observe(this, Observer {finishedLoading->
            if(finishedLoading){
                // Paso automático al main
                passViewGoToMain()
            }
        })
    }

    private fun passViewGoToMain(){
        // Realiza cambio entre vistas
        var intent: Intent = Intent(this, MainActivity::class.java)
        // Borra historial de pantallas --> para no regresar a splashscreen
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        // Inicia nueva actividad
        startActivity(intent)
        // Termina la vista de manera segura
        finish()
    }

}