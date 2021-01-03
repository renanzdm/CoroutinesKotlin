package br.com.deckofcards.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.deckofcards.R
import br.com.deckofcards.data.model.Card
import br.com.deckofcards.data.model.NewDeckCard
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(private val cards: ArrayList<Card>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(deck: Card) {
            itemView.apply {
                textViewUserName.text = deck.code
                textViewUserEmail.text = deck.suit
                Glide.with(imageViewAvatar.context)
                    .load(deck.image)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(cards[position])
    }
fun addNewDeck(cards: List<Card>){
        this.cards.apply {
            clear()
            addAll(cards)
        }


    }



    }
