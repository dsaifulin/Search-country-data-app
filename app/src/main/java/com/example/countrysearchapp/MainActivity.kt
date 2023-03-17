package com.example.countrysearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restCountries = RestCountries()
        val countryNameWidget: TextView = findViewById(R.id.CountryName)
        val capitalNameWidget: TextView = findViewById(R.id.capitalName)
        val populationWidget: TextView = findViewById(R.id.populationText)
        val areaWidget: TextView = findViewById(R.id.areaText)
        val languagesWidget: TextView = findViewById(R.id.languagesText)
        val imageWidget: ImageButton = findViewById(R.id.countryImage)
        val searchButtonWidget: Button = findViewById(R.id.searchCountryButton)
        val editCountryText: EditText = findViewById(R.id.editTextCountry)

        searchButtonWidget.setOnClickListener {
            val searchCountryName = editCountryText.text.toString()
            lifecycleScope.launch {
                val country = restCountries.restCountriesService.getCountryByName(searchCountryName)[0]
                countryNameWidget.text = country.countryName
                capitalNameWidget.text = country.capitalName
                populationWidget.text = country.population.toString()
                areaWidget.text = country.area.toString()
                languagesWidget.text = country.languages.toString()
                //imageWidget
            }

        }


    }

}