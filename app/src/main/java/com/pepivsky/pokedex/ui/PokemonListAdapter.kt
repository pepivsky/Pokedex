package com.pepivsky.pokedex.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pepivsky.pokedex.model.PokemonItem

class PokemonListAdapter: RecyclerView.Adapter<PokemonListViewHolder>() {

    //lista para el recycler
    private val pokemonList: MutableList<PokemonItem> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        return PokemonListViewHolder(LayoutInflater.from(parent.context))
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    //convertido a expresion
    override fun getItemCount(): Int = pokemonList.size


    fun submitList(list: List<PokemonItem>) {
        pokemonList.clear()
        pokemonList.addAll(list)
    }

}