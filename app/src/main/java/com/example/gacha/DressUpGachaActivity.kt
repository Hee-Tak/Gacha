package com.example.gacha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DressUpGachaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dress_up_gacha)

        val button = findViewById<Button>(R.id.back)
        button.setOnClickListener{
            onBackPressed()
        }

    }



    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}