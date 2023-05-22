package com.tech.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var addition : Button
    lateinit var subtraction :Button
    lateinit var multiplication :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addition = findViewById(R.id.buttonadd)
        subtraction = findViewById(R.id.buttonsub)
        multiplication = findViewById(R.id.buttonmul)

        addition.setOnClickListener {
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            startActivity(intent)
        }
    }
}