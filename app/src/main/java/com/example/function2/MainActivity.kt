package com.example.function2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var txtResult: TextView
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnClear: Button

    private var a = 0
    private var b = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        txtResult = findViewById(R.id.txtResult)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnClear = findViewById(R.id.btnClear)

        btnAdd.setOnClickListener {
            txtResult.text = addNumbers().toString()
        }

        btnSubtract.setOnClickListener {
            txtResult.text = subtractNumbers().toString()
        }

        btnClear.setOnClickListener {
            num1.text.clear()
            num2.text.clear()
            txtResult.text = "Output Result"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun inputData() {
        a = num1.text.toString().toIntOrNull() ?: 0
        b = num2.text.toString().toIntOrNull() ?: 0
    }

    private fun addNumbers(): Int {
        inputData()
        return a + b
    }

    private fun subtractNumbers(): Int {
        inputData()
        return a - b
    }
}
