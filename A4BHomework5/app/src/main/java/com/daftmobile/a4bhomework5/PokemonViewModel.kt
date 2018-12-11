package com.daftmobile.a4bhomework5

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by Konrad Kowalewski.
 */
class PokemonViewModel: ViewModel() {

    private val pokemonLiveData = SingleLiveEvent<PokemonItem>()
    private val errorLiveData = SingleLiveEvent<String>()
    private val dataSource = Fetcher()

    fun newPokemon(): LiveData<PokemonItem> = pokemonLiveData
    fun error(): LiveData<String> = errorLiveData

    fun showPokemonInfo(index: String) {
       // TODO("Fetch pokemon data")
       dataSource.fetch(index,{ pokemonLiveData.setValue(it) },{ errorLiveData.value=it})
    }
}
