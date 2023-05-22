package com.tech.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    lateinit var textScore : TextView
    lateinit var textLife :TextView
    lateinit var textTime : TextView
    lateinit var buttonOk : Button
    lateinit var buttonNext :Button
    lateinit var textQuestion : TextView
    lateinit var editAnswer:EditText
    lateinit var editTextAnswer:EditText



    var correctAnswer = 0
    var userScore = 0
    var userLife = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)
        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)
        textQuestion = findViewById(R.id.textViewQuestion)
        editAnswer = findViewById(R.id.editTextAnswer)
        gameContinue()

        buttonOk.setOnClickListener{
            val input = editTextAnswer.text.toString()
            if(input== ""){  //if a user inputs nothing to the textViewQuestion or no data entered
                Toast.makeText(applicationContext, "please write an answer or click the next button" ,
                    Toast.LENGTH_LONG).show()
            }
            else {
                val userAnswer = input.toInt()  //converting to integer
                if(userAnswer == correctAnswer){  // if a user gives a right answer
                    userScore = userScore + 10
                    textQuestion.text = "Congratulation , your answer is correct"
                    textScore.text = userScore.toString()
                }
                else{
                    userLife--
                    textQuestion.text = "Sorry your answer is wrong"
                    textLife.text= userLife.toString()
                }
            }

        }
        buttonNext.setOnClickListener {
            gameContinue()
            editTextAnswer.setText(" ")

        }
    }
    fun gameContinue() {
       val number1 =  Random.nextInt(0, 100)
        val number2 =  Random.nextInt(0, 100)
        textQuestion.text = "$number1 +$number2" //adding numbers to the textQuestion
        correctAnswer = number1 + number2

    }

}