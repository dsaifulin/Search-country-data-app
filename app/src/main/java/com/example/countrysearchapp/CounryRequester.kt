package com.example.countrysearchapp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RestCountriesService {
    @GET("name/{name}")
    suspend fun getCountryByName(@Path("name") countryName: String): List<Country>
}

    var retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var restCountriesService = retrofit.create(RestCountriesService::class.java)
