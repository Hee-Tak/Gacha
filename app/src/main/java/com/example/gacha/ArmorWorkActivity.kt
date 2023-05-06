package com.example.gacha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ArmorWorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_armor_work)

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


