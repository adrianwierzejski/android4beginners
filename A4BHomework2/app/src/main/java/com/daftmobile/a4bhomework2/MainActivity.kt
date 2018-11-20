package com.daftmobile.a4bhomework2

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b_Red.setOnClickListener ( this::onButtonClicked )
        b_Blue.setOnClickListener ( this::onButtonClicked )
        b_Green.setOnClickListener ( this::onButtonClicked )

    }
    private fun onButtonClicked(view: View){
        val b: Button= view as Button
        AlertDialog.Builder(this).setMessage(getString(R.string.ButtonTapped,b.text)).apply {
            setPositiveButton(android.R.string.ok,null)}.show()
    }
}
