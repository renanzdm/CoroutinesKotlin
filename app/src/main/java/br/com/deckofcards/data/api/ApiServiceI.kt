package br.com.deckofcards.data.api

import br.com.deckofcards.data.model.NewDeckCard
import retrofit2.http.GET

interface ApiServiceI {
    @GET("draw/?count=2")
    suspend fun createNewDeck():NewDeckCard


}