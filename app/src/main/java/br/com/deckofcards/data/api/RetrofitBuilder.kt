package br.com.deckofcards.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
  private const val BASE_URL = "https://deckofcardsapi.com/api/deck/new/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiServiceI : ApiServiceI = getRetrofit().create(ApiServiceI::class.java)

}