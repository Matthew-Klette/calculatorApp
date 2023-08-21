package com.example.calculatorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private val CALCULATE = "Answers" //The IIE. (2023).

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)//The IIE. (2023).
        val editTextText2 = findViewById<EditText>(R.id.editTextText2)//The IIE. (2023).
        val editTextText3 = findViewById<EditText>(R.id.editTextText3)//The IIE. (2023).
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)//The IIE. (2023).
        val buttonMinus = findViewById<Button>(R.id.buttonMinus)//The IIE. (2023).
        val buttonTimes = findViewById<Button>(R.id.buttonTimes)//The IIE. (2023).
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)//The IIE. (2023).





        buttonAdd?.setOnClickListener {
            val numberOne = editTextText2.text.toString().toInt() //The IIE. (2023).
            val numberTwo = editTextText3.text.toString().toInt()

            val sum: Number = numberOne + numberTwo
            textViewTitle.text = "${editTextText2.text} + ${editTextText3.text} = $sum!"  //The IIE. (2023).
            //This code segment will add the users numbers together and display the answer

            Log.v(CALCULATE, "${editTextText2.text} + ${editTextText3.text} = $sum!")
            //This will display the calculation and answer in the logcat after the program has been run.
        }

        buttonMinus?.setOnClickListener {
            val numberOne = editTextText2.text.toString().toInt() //The IIE. (2023).
            val numberTwo = editTextText3.text.toString().toInt()

            val sum: Number = numberOne - numberTwo
            textViewTitle.text = "${editTextText2.text} - ${editTextText3.text} = $sum!"  //The IIE. (2023).
            //This code segment will subtract the users numbers and display the answer

            Log.v(CALCULATE, "${editTextText2.text} - ${editTextText3.text} = $sum!")

        }

        buttonTimes?.setOnClickListener {
            val numberOne = editTextText2.text.toString().toInt() //The IIE. (2023).
            val numberTwo = editTextText3.text.toString().toInt()

            val sum: Number = numberOne * numberTwo
            textViewTitle.text = "${editTextText2.text} x ${editTextText3.text} = $sum!" //The IIE. (2023).
            //This code segment will multiply the users numbers together and display the answer

            Log.v(CALCULATE, "${editTextText2.text} x ${editTextText3.text} = $sum!")
        }

        buttonDivide?.setOnClickListener {
            val numberOne = editTextText2.text.toString().toInt()//The IIE. (2023).
            val numberTwo = editTextText3.text.toString().toInt()

            val sum: Number = numberOne % numberTwo
            val remainder = numberOne % numberTwo
            textViewTitle.text = "${editTextText2.text} / ${editTextText3.text} = $sum remainder ${remainder}!" //The IIE. (2023).
            //This code segment will divide the users numbers and display the answer as well as any remainders

            Log.v(CALCULATE, "${editTextText2.text} / ${editTextText3.text} = $sum remainder ${remainder}!")
        }

    }

}

/* References:
The IIE. 2023.
Introduction to Mobile Application Development [IMAD5112/d/w MODULE MANUAL].
The Independent Institute of Education: Unpublished.
 */