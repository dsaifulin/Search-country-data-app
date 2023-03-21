package com.example.countrysearchapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.countrysearchapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.searchCountryButton.setOnClickListener {
                val searchCountryName = binding.editTextCountry.text.toString()
                lifecycleScope.launch {
                    try{
                        val country = restCountriesService.getCountryByName(searchCountryName)[0]
                        binding.CountryName.text = stringCutter(country.name, 20)
                        binding.capitalName.text = country.capital
                        binding.populationText.text = String.format("%,d", country.population).replace(",", ".")
                        binding.areaText.text = String.format("%,d", country.area).replace(",", ".")
                        binding.languagesText.text = country.languages.joinToString { it.name }

                        binding.imageFlag.load(country.flags.png) {
                            placeholder(R.drawable.flag)
                        }
                    }
                    catch(e: Exception) {
                        binding.statusText.text = "Error! Please, try again..."
                        binding.statusImage.setImageResource(R.drawable.error_status)
                        binding.resultLayout.visibility = View.INVISIBLE
                        binding.statusLayout.visibility = View.VISIBLE
                    }
                }
                binding.resultLayout.visibility = View.VISIBLE
                binding.statusLayout.visibility = View.INVISIBLE
            }
        }


    }


