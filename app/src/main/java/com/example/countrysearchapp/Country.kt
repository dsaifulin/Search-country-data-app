package com.example.countrysearchapp


data class Country(val name: String,
              val capital: String,
              val population: Long,
              val area: Long,
              val languages: List<Language>,
               val flags: Image
                )


data class Language(
    val name: String
)

data class Image(
    val png: String
)
