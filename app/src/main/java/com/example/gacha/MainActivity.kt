package com.example.gacha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var myButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.my_button)
        myButton.setOnClickListener{

        }
    }

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
}