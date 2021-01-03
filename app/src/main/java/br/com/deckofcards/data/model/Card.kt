package br.com.deckofcards.data.model

import com.google.gson.annotations.SerializedName



data class Card (
    @SerializedName(value = "image")
    val image: String,
    @SerializedName(value = "value")
    val value: String,
    @SerializedName(value = "suit")
    val suit: String,
    @SerializedName(value = "code")
    val code: String
)


