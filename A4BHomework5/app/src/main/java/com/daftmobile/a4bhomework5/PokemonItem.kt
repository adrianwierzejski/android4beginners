package com.daftmobile.a4bhomework5

import android.support.annotation.ColorInt
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonItem (@SerializedName("number") val index: String, val name: String, @SerializedName("color") @ColorInt val backgroundColor: Int):Serializable
