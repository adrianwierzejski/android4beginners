package com.daftmobile.a4bhomework5

import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_pokemon.*

class PokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        //TODO("Retrieve pokemon data to display")
        val pokemon =intent.getSerializableExtra("data") as PokemonItem
        imageView.setImageResource(R.color.tooltip_background_light)
        imageView.setColorFilter(Color.parseColor("#${java.lang.Integer.toHexString(pokemon.backgroundColor)}"),PorterDuff.Mode.SRC_ATOP)
        nameView.setText(pokemon.name)
        numberView.setText(pokemon.index)
    }
}
