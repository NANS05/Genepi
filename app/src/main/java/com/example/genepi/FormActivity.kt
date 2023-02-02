package com.example.genepi

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.genepi.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_form)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        var textFirstName = ""
        var ratingKotlin = 0
        var userHapiness = 0

        var toastButton = findViewById<Button>(R.id.main_button_toast)
        var firstnameEditText = findViewById<EditText>(R.id.main_edittext_firstname)
        var ratingBar = findViewById<RatingBar>(R.id.main_ratingBar)
        var seekBar = findViewById<SeekBar>(R.id.main_seekBar)
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

        ratingBar.setOnRatingBarChangeListener(object : RatingBar.OnRatingBarChangeListener {
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                ratingKotlin = rating.toInt()
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?){}
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                userHapiness = progress
            }
        })

        formButton.setOnClickListener {
            Toast.makeText( this, "Bonjour ${textFirstName}", Toast.LENGTH_LONG).show()
        }
    }
}