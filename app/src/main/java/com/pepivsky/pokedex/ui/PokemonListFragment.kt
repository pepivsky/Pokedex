package com.pepivsky.pokedex.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pepivsky.pokedex.R
import com.pepivsky.pokedex.databinding.PokemonListFragmentBinding
import com.pepivsky.pokedex.model.PokemonItem
import kotlinx.android.synthetic.main.pokemon_list_fragment.*

class PokemonListFragment : Fragment() {

    private lateinit var viewModel: PokemonListViewModel
    private var adapter: PokemonListAdapter? = null
    private var binding : PokemonListFragmentBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)
        initializeui()
        // TODO: Use the ViewModel
    }

    //funcion que inicializa la UI
    private fun initializeui() {
        binding?.apply {
            val list = listOf(PokemonItem("Pikachu"), PokemonItem("Charmander"))
            adapter= PokemonListAdapter().also { it.submitList(list) } //cambio
            pokemonList.layoutManager = LinearLayoutManager(context)
            pokemonList.adapter= adapter


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



    companion object {
        fun newInstance() = PokemonListFragment()
    }

}