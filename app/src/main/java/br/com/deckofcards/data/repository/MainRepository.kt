package br.com.deckofcards.data.repository

import br.com.deckofcards.data.api.ApiHelper
import br.com.deckofcards.data.model.Card
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun createNewDeck()  = apiHelper.createNewDeck()
}