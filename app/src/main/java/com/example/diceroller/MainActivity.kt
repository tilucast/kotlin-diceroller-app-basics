package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/*
* This activity makes the button trigger a function that displays a random number on the screen.
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }

        rollDice()
    }

    /*
    * Roll the dice and update the screen with a random number.
    * */
    private fun rollDice() {
        val dice = Dice(6)
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        diceImage.setImageResource(randomDiceImage(dice.roll()))
        diceImage2.setImageResource(randomDiceImage(dice.roll()))
        //val diceRoll = dice.roll()
        //diceImage.contentDescription = diceRoll.toString()
        //diceImage2.contentDescription = diceRoll.toString()
    }

    private fun randomDiceImage(randomNumber: Int): Int{
        return when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}