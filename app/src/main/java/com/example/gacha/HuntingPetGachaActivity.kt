package com.example.gacha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HuntingPetGachaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hunting_pet_gacha)

        val button = findViewById<Button>(R.id.back_and_home)
        button.setOnClickListener{
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}