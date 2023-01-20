package com.example.genepi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this, R.string.text_toast, Toast.LENGTH_LONG).show()
        }

        var buttonForm = findViewById<Button>(R.id.buttonForm)
        buttonForm.setOnClickListener {
            setContentView(R.layout.formulaire)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(MainActivity::class.simpleName, "The user open the app")
    }
}