package com.example.genepi

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textFirstName = ""

        var toastButton = findViewById<Button>(R.id.main_button_toast)
        var firstnameEditText = findViewById<EditText>(R.id.main_edittext_firstname)
        var formButton = findViewById<Button>(R.id.main_button_form)

        formButton.isEnabled = false;

        toastButton.setOnClickListener {
            Toast.makeText(this, R.string.text_toast, Toast.LENGTH_LONG).show()
        }

        firstnameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                textFirstName = s.toString()
                formButton.isEnabled = s.toString().isNotEmpty()
            }
        })

        formButton.setOnClickListener {
            Toast.makeText( this, "Bonjour ${textFirstName}", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(MainActivity::class.simpleName, "The user open the app")
    }
}