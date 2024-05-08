package com.example.module2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.buttonRollDice)
        rollButton.setOnClickListener {
            rollDice()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun rollDice(){
        val dice = Dice(6)
        val dice2 = Dice2(6)
        val diceRolled = dice.diceRoll()
        val diceRolled2 = dice2.diceRoll()
        val result1: ImageView = findViewById(R.id.imageDice1)
        val result2: ImageView = findViewById(R.id.imageDice2)

        when(diceRolled){
            1 -> result1.setImageResource(R.drawable.dice_1)
            2 -> result1.setImageResource(R.drawable.dice_2)
            3 -> result1.setImageResource(R.drawable.dice_3)
            4 -> result1.setImageResource(R.drawable.dice_4)
            5 -> result1.setImageResource(R.drawable.dice_5)
            else -> result1.setImageResource(R.drawable.dice_6)
        }
        when(diceRolled2){
            1 -> result2.setImageResource(R.drawable.dice_1)
            2 -> result2.setImageResource(R.drawable.dice_2)
            3 -> result2.setImageResource(R.drawable.dice_3)
            4 -> result2.setImageResource(R.drawable.dice_4)
            5 -> result2.setImageResource(R.drawable.dice_5)
            else -> result2.setImageResource(R.drawable.dice_6)
        }

        if(diceRolled == diceRolled2){
            Toast.makeText(this, "Selamat Anda mendapatkan dadu double", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Anda belum beruntung", Toast.LENGTH_SHORT).show()
        }
    }

    class Dice(val numSides: Int){
        fun diceRoll(): Int {
            return (1..numSides).random()
        }
    }

    class Dice2(val numSides: Int){
        fun diceRoll(): Int{
            return (1..numSides).random()
        }
    }
}