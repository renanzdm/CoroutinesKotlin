package br.com.deckofcards.ui.main

import br.com.deckofcards.model.Filme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {
    fun getFilmes(callback: (filmes:List<Filme>)->Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(0, "Casa assombrada"),
                    Filme(1, "De volta para o futuro")
                )
            )
        }).start()
    }

suspend fun getFilmesCoroutines():List<Filme>{
   return withContext(Dispatchers.Default){
        delay(3000)
        listOf(
            Filme(0, "Casa assombrada"),
            Filme(1, "De volta para o futuro")
        )
    }

}


}