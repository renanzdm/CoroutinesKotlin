package br.com.deckofcards.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import br.com.deckofcards.data.model.Card
import br.com.deckofcards.data.repository.MainRepository
import br.com.deckofcards.utils.Responses
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getNewDeck() = liveData(Dispatchers.IO) {
        emit(Responses.loading(data = null))
        try {
            emit(Responses.success(data = mainRepository.createNewDeck()))
        } catch (exception: Exception) {
            emit(Responses.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}