package br.com.deckofcards.utils

data class Responses<out T>(val status:Status, val data:T?, val message:String?){
    companion object{

        fun <T> success(data: T?):Responses<T>{
            return Responses(Status.SUCCESS,data, null)
        }
        fun <T> error(message: String, data: T?): Responses<T> {
            return Responses(Status.ERROR, data, message)
        }

        fun <T> loading(data: T?): Responses<T> {
            return Responses(Status.LOADING, data, null)
        }
    }


}
