package com.example.gacha

import android.app.ListActivity
import android.content.ClipDescription
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val showListButton = findViewById<Button>(R.id.my_button)
        showListButton.setOnClickListener {
            val intent = Intent(this, GachaListActivity::class.java)
            startActivity(intent)
        }

        val showListButton1 = findViewById<Button>(R.id.gambling)
        showListButton1.setOnClickListener {
            val intent = Intent(this, GamblingListActivity::class.java)
            startActivity(intent)
        }

        val button = findViewById<Button>(R.id.goto_fishing)
        button.setOnClickListener {
            val intent = Intent(this, FishingActivity::class.java)
            startActivity(intent)
        }

    }



}



/*
    private fun ItemGacha() {
        val randomNumber = Random.nextInt(1, 1001)
        val C = itemLevel(randomNumber)


    }

    private fun itemLevel(randomNumber: Int): String{
        return when(randomNumber){
            in 1..10 -> "S"
            in 11..100 -> "A"
            in 101..300 -> "B"
            in 301..600 -> "C"
            else -> "D"
        }

    }

 */
