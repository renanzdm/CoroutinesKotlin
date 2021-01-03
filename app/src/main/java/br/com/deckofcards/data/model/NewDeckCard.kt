package br.com.deckofcards.data.model

import com.google.gson.annotations.SerializedName

data class NewDeckCard (
    @SerializedName(value = "success")
    val success: Boolean,
    @SerializedName(value = "cards")
    val cards: List<Card>,
    @SerializedName(value = "deckID")
    val deckID: String,
    @SerializedName(value = "remaining")
    val remaining: Long
)