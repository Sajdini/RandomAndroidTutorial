package com.android.gsixacademy.randomandroidtutorial

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator_layout.*


class CalculatorActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_layout)
        initListeners()
    }

    private fun initListeners() {
        // this sets the button on function
        button_add.setOnClickListener {
            var firstNumberText = edit_text_number_one.text.toString()
            var secondNumberText = edit_text_number_two.text.toString()
            if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
                text_view_result_value.text = "0"
                Toast.makeText(applicationContext, "no value entered", Toast.LENGTH_LONG).show()
            } else {
                var result = firstNumberText.toDouble() + secondNumberText.toDouble()
                text_view_result_value.text = "$result"
            }
        }
        button_subb.setOnClickListener {
            var firstNumberText = edit_text_number_one.text.toString()
            var secondNumberText = edit_text_number_two.text.toString()

            if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
                text_view_result_value.text = "0"
                Toast.makeText(applicationContext, "no value entered", Toast.LENGTH_LONG).show()
            } else {
                var result = firstNumberText.toDouble() - secondNumberText.toDouble()
                text_view_result_value.text = "$result"

            }
        }
        button_multiply.setOnClickListener {
            var firstNumberText = edit_text_number_one.text.toString()
            var secondNumberText = edit_text_number_two.text.toString()
            if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
                text_view_result_value.text = "0"
                Toast.makeText(applicationContext, "no value entered", Toast.LENGTH_LONG).show()
            } else {
                var result = firstNumberText.toDouble() * secondNumberText.toDouble()
                text_view_result_value.text = "$result"
            }
        }


        button_divide.setOnClickListener {
            var firstNumberText = edit_text_number_one.text.toString()
            var secondNumbertext = edit_text_number_two.text.toString()
            if (firstNumberText.isEmpty() || secondNumbertext.isEmpty()) {
                text_view_result_value.text = "/"
                Toast.makeText(applicationContext, "no value entered", Toast.LENGTH_LONG).show()
            } else if (secondNumbertext.toInt() == 0) {
                text_view_result_value.text = "/"
                Toast.makeText(
                    applicationContext,
                    "second number must not be '0'",
                    Toast.LENGTH_LONG
                )
                    .show()
            } else {
                var result = firstNumberText.toDouble() / secondNumbertext.toDouble()
                text_view_result_value.text = "$result"
            }
        }
    }
}