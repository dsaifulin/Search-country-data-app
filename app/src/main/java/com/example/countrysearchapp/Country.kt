package com.example.countrysearchapp

data class Country(val countryName: String,
              val capitalName: String,
              val population: Long,
              val area: Long,
              val languages: List<Language>,
                )
//data class CountryName(val name: String)
data class Language(val language: String)