package com.example.calculatorapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private val CALCULATE = "Answers" //The IIE. (2023).

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Declarations
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)//The IIE. (2023).
        val textViewError = findViewById<TextView>(R.id.textViewError)//The IIE. (2023).
        val editTextText2 = findViewById<EditText>(R.id.editTextText2)//The IIE. (2023).
        val editTextText3 = findViewById<EditText>(R.id.editTextText3)//The IIE. (2023).
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)//The IIE. (2023).
        val buttonMinus = findViewById<Button>(R.id.buttonMinus)//The IIE. (2023).
        val buttonTimes = findViewById<Button>(R.id.buttonTimes)//The IIE. (2023).
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)//The IIE. (2023).
        val buttonSquare = findViewById<Button>(R.id.buttonSquare)//The IIE. (2023).
        val buttonPower = findViewById<Button>(R.id.buttonPower)//The IIE. (2023).
        val buttonStats = findViewById<Button>(R.id.buttonStats)//The IIE. (2023).



        buttonStats.setOnClickListener {

            val intent = Intent(this, Statistics::class.java)

            startActivity(intent)
        }







        //Square Root Calculation
        buttonSquare?.setOnClickListener {
            val numberOne = editTextText2.text.toString().trim()



            //If the fields are empty
            if (numberOne.isEmpty()) {
                textViewError.text = "Please enter a number!"
                textViewError.setTextColor(Color.parseColor("#FF6060"))
            } else { //If the values are 0
                val numberOne = editTextText2.text.toString().toInt()
                val squareRoot: Number = sqrt(numberOne.toDouble())

                //if number is less than 0
                if (numberOne < 0) {
                    val double: Number = numberOne - numberOne - numberOne
                    val answer: Number = sqrt(double.toDouble())

                    textViewTitle.text = "sqrt(${editTextText2.text}) = $answer i"

                    Log.v(CALCULATE, "sqrt(${editTextText2.text}) =$answer i")
                } else { //Regular square root calculation
                    val answer: Number = sqrt(numberOne.toDouble())


                    textViewTitle.text = "sqrt(${editTextText2.text}) = ${squareRoot}"

                    textViewError.text = "Any Errors will be displayed here."
                    textViewError.setTextColor(Color.parseColor("#FFD9C8"))

                    Log.v(CALCULATE, "sqrt(${editTextText2.text}) = ${squareRoot}")
                }
            }
        }


//Addition Calculation
        buttonAdd?.setOnClickListener {
            val numberOne = editTextText2.text.toString().trim()
            val numberTwo = editTextText3.text.toString().trim()


            //If the fields are empty
            if (numberOne.isEmpty() || numberTwo.isEmpty()) {
                textViewError.text = "Please enter both numbers!"
                textViewError.setTextColor(Color.parseColor("#FF6060"))
            } else { //If the values are 0
                //The IIE. (2023).
                val numberOne = editTextText2.text.toString().toInt()
                val numberTwo = editTextText3.text.toString().toInt()

                val sum: Number = numberOne + numberTwo

                textViewTitle.text = "${editTextText2.text} + ${editTextText3.text} = $sum"
                //The IIE. (2023).
                //This code segment will add the users numbers together and display the answer

                textViewError.text = "Any Errors will be displayed here."
                textViewError.setTextColor(Color.parseColor("#FFD9C8"))

                Log.v(CALCULATE, "${editTextText2.text} + ${editTextText3.text} = $sum")
                //This will display the calculation and answer in the logcat after the program has been run.
            }
        }


        //Subtraction Calculation
        buttonMinus?.setOnClickListener {
            val numberOne = editTextText2.text.toString().trim()
            val numberTwo = editTextText3.text.toString().trim()


            //If the fields are empty
            if (numberOne.isEmpty() || numberTwo.isEmpty()) {
                textViewError.text = "Please enter both numbers!"
                textViewError.setTextColor(Color.parseColor("#FF6060"))
            } else { //If the values are 0
                //The IIE. (2023).
                val numberOne = editTextText2.text.toString().toInt()
                val numberTwo = editTextText3.text.toString().toInt()

                val sum: Number = numberOne - numberTwo

                textViewTitle.text = "${editTextText2.text} - ${editTextText3.text} = $sum"
                //The IIE. (2023).
                //This code segment will subtract the users numbers and display the answer

                textViewError.text = "Any Errors will be displayed here."
                textViewError.setTextColor(Color.parseColor("#FFD9C8"))

                Log.v(CALCULATE, "${editTextText2.text} - ${editTextText3.text} = $sum")
            }
        }


        //Multiplication Calculation
        buttonTimes?.setOnClickListener {
            val numberOne = editTextText2.text.toString().trim()
            val numberTwo = editTextText3.text.toString().trim()


            //If the fields are empty
            if (numberOne.isEmpty() || numberTwo.isEmpty()) {
                textViewError.text = "Please enter both numbers!"
                textViewError.setTextColor(Color.parseColor("#FF6060"))
            } else { //If the values are 0
                //The IIE. (2023).
                val numberOne = editTextText2.text.toString().toInt()
                val numberTwo = editTextText3.text.toString().toInt()

                val sum: Number = numberOne * numberTwo

                textViewTitle.text = "${editTextText2.text} x ${editTextText3.text} = $sum"
                //The IIE. (2023).
                //This code segment will multiply the users numbers together and display the answer

                textViewError.text = "Any Errors will be displayed here."
                textViewError.setTextColor(Color.parseColor("#FFD9C8"))

                Log.v(CALCULATE, "${editTextText2.text} x ${editTextText3.text} = $sum")
            }
        }


        //Division Calculation
        buttonDivide?.setOnClickListener {
            //The IIE. (2023).
            val numberOne = editTextText2.text.toString().trim()
            val numberTwo = editTextText3.text.toString().trim()


            //If the fields are empty
            if (numberOne.isEmpty() || numberTwo.isEmpty()) {
                textViewError.text = "Please enter both numbers!"
                textViewError.setTextColor(Color.parseColor("#FF6060"))
            } else { //If the values are 0
                val numberOne = editTextText2.text.toString().toIntOrNull()
                val numberTwo = editTextText3.text.toString().toIntOrNull()

                if (numberOne == null || numberTwo == null) {
                    textViewError.text = "Please enter valid numbers!"
                    textViewError.setTextColor(Color.parseColor("#FF6060"))
                } else {//If the second field is 0
                    if (numberTwo == 0) {
                        textViewError.text = "You cannot divide by 0!"
                        textViewError.setTextColor(Color.parseColor("#FF6060"))
                    } else {//Regular Division calculation
                        val sum: Number = numberOne / numberTwo
                        val remainder = numberOne % numberTwo

                        textViewTitle.text =
                            "${editTextText2.text} / ${editTextText3.text} = $sum remainder ${remainder}"
                        //The IIE. (2023).
                        //This code segment will divide the users numbers and display the answer as well as any remainders

                        textViewError.text = "Any Errors will be displayed here."
                        textViewError.setTextColor(Color.parseColor("#FFD9C8"))

                        Log.v(
                            CALCULATE,
                            "${editTextText2.text} / ${editTextText3.text} = $sum remainder ${remainder}"
                        )
                    }
                }
            }
        }


//Power Calculation
        buttonPower?.setOnClickListener {
            val numberOne = editTextText2.text.toString().trim()
            val numberTwo = editTextText3.text.toString().trim()


            //If the fields are empty
            if (numberOne.isEmpty() || numberTwo.isEmpty() ) {
                textViewError.text = "Please enter both numbers!"
                textViewError.setTextColor(Color.parseColor("#FF6060"))
            } else { //If the values are 0
                //The IIE. (2023).
                var numberOne = editTextText2.text.toString().toInt()
                var numberTwo = editTextText3.text.toString().toInt()

                var result: Long = 1


                //While the exponent is 0
                while (numberTwo != 0) {
                    result *= numberOne.toLong()
                    --numberTwo
                }

//Regular power calculation
                textViewTitle.text = "${editTextText2.text} ^ ${editTextText3.text} = $result"
                //The IIE. (2023).
                //This code segment will divide the users numbers and display the answer as well as any remainders

                textViewError.text = "Any Errors will be displayed here."
                textViewError.setTextColor(Color.parseColor("#FFD9C8"))

                Log.v(
                    CALCULATE, "${editTextText2.text} / ${editTextText3.text} = $result"
                )
            }
        }
    }
}


/* References:
The IIE. 2023.
Introduction to Mobile Application Development [IMAD5112/d/w MODULE MANUAL].
The Independent Institute of Education: Unpublished.
 */