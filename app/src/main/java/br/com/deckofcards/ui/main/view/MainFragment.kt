package br.com.deckofcards.ui.main.view

import android.annotation.SuppressLint
import br.com.deckofcards.ui.main.viewmodel.MainViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.deckofcards.R
import br.com.deckofcards.data.api.ApiHelper
import br.com.deckofcards.data.api.RetrofitBuilder
import br.com.deckofcards.data.model.Card
import br.com.deckofcards.data.model.NewDeckCard
import br.com.deckofcards.ui.main.adapter.MainAdapter
import br.com.deckofcards.ui.main.base.MainViewModelFactory
import br.com.deckofcards.utils.Status
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {


    private lateinit var adapter: MainAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViewModel()
        setupUI()
        setupObservers()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
           MainViewModelFactory(ApiHelper(RetrofitBuilder.apiServiceI))
        ).get(MainViewModel::class.java)
    }
    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }
    private fun setupObservers() {
        viewModel.getNewDeck().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {

                        resource.data?.let { deck -> retrieveList(deck) }
                        progressBar.visibility = View.GONE
                        recyclerView.visibility = View.VISIBLE

                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(context,it.message,Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(deck:NewDeckCard) {
        Log.i("print","$deck")
    adapter.apply {
    addNewDeck(deck.cards)
    notifyDataSetChanged()
}


    }

}