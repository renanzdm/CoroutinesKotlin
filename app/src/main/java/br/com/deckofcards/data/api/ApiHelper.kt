package br.com.deckofcards.data.api

class ApiHelper(private val apiService: ApiServiceI) {
    suspend fun createNewDeck() = apiService.createNewDeck()

}