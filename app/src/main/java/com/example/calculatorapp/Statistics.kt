package com.example.calculatorapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Statistics : AppCompatActivity() {
    private val CALCULATE = "Answers" //The IIE. (2023).

    var numbers = arrayOf<String>(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )
    var counter = 0


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.statistics)

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


        val editTextStats = findViewById<EditText>(R.id.editTextStats)//The IIE. (2023).
        val buttonAddNum = findViewById<Button>(R.id.buttonAddNum)

        val textViewStored = findViewById<TextView>(R.id.textViewStored)//The IIE. (2023).
        val buttonClear = findViewById<Button>(R.id.buttonClear)//The IIE. (2023).
        val textViewAnswer = findViewById<TextView>(R.id.textViewAnswer)//The IIE. (2023).
        val buttonMinMax = findViewById<Button>(R.id.buttonMinMax)//The IIE. (2023).
        val buttonAverage = findViewById<Button>(R.id.buttonAverage)//The IIE. (2023).
        val buttonBack = findViewById<Button>(R.id.buttonBack)//The IIE. (2023).

        buttonBack.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }


        buttonAddNum?.setOnClickListener {
            val input = editTextStats.text.toString()

            if (counter > numbers.size) {
                textViewStored.text = "Invalid input. Counter is larger than the array size."
            } else if (counter < 10) {
                if (input.isNotBlank()) {
                    val number = input.toDoubleOrNull()

                    if (number != null) {
                        if (counter < numbers.size) {
                            numbers[counter] = number.toString()
                            counter++
                            val display = numbers.take(counter).joinToString("  ")
                            textViewStored.text = display
                        } else {
                            textViewStored.text = "Invalid input. Counter is larger than the array size."
                        }
                    } else {
                        textViewStored.text = "Invalid input. Please enter a valid number."
                    }
                } else {
                    textViewStored.text = "Invalid input. Please enter a valid number."
                }
            } else {
                textViewStored.text = "Cannot add more numbers. Only 10 numbers allowed."
            }
        }



        buttonAverage?.setOnClickListener {
            if (counter == 0) {
                textViewAnswer.text = "No numbers to calculate the average."
            } else {
                var sum = 0.0
                var index = 0
                while (index < counter) {
                    sum += numbers[index].toDoubleOrNull() ?: 0.0 //This will either use the calculation in order to find the average, or recognize of the value is void.
                    index++
                }
                val average = sum / counter
                textViewAnswer.text = "Average: $average"

                Log.v(CALCULATE, "Average = ${average}")
            }
        }



        buttonClear.setOnClickListener {

            numbers = Array(10) { null.toString() }
            counter = 0


            textViewStored.text = ""
            textViewAnswer.text = "Answer will be displayed here"
            // The first display will clear the message and the second display will replace the error message if the situation occurs.

        }

        buttonMinMax.setOnClickListener {
            if (counter == 0) {

                textViewAnswer.text = "No numbers entered." // I added an error message for when no numbers are entered.
            } else {
                val validNumbers = numbers.take(counter).mapNotNull { it.toDoubleOrNull() }

                if (validNumbers.isNotEmpty()) {
                    val min = validNumbers.minOrNull()
                    val max = validNumbers.maxOrNull()

                    if (min != null && max != null) {
                        textViewAnswer.text = "Min: $min , Max: $max"
                        Log.v(CALCULATE, "Min = ${min} and Max = ${max}")
                    }
                } else {
                    textViewAnswer.text = "Invalid input. Please enter valid numbers."
                }
            }
        }


    }
}




/* References:
The IIE. 2023.
Introduction to Mobile Application Development [IMAD5112/d/w MODULE MANUAL].
The Independent Institute of Education: Unpublished.
 */