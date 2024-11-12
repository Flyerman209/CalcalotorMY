package com.example.calcalotormy



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var currentNumber = ""
    private var operation = ""
    private var firstNumber = 0.0
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация TextView
        tvResult = findViewById(R.id.tvResult)

        // Инициализация кнопок
        findViewById<Button>(R.id.btn0).setOnClickListener { appendNumber("0") }
        findViewById<Button>(R.id.btn1).setOnClickListener { appendNumber("1") }
        findViewById<Button>(R.id.btn2).setOnClickListener { appendNumber("2") }
        findViewById<Button>(R.id.btn3).setOnClickListener { appendNumber("3") }
        findViewById<Button>(R.id.btn4).setOnClickListener { appendNumber("4") }
        findViewById<Button>(R.id.btn5).setOnClickListener { appendNumber("5") }
        findViewById<Button>(R.id.btn6).setOnClickListener { appendNumber("6") }
        findViewById<Button>(R.id.btn7).setOnClickListener { appendNumber("7") }
        findViewById<Button>(R.id.btn8).setOnClickListener { appendNumber("8") }
        findViewById<Button>(R.id.btn9).setOnClickListener { appendNumber("9") }

        findViewById<Button>(R.id.btnAdd).setOnClickListener { setOperation("+") }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { setOperation("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { setOperation("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { setOperation("/") }

        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculateResult() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { clear() }
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        tvResult.text = currentNumber
    }

    private fun setOperation(op: String) {
        if (currentNumber.isNotEmpty()) {
            firstNumber = currentNumber.toDouble()
            currentNumber = ""
            operation = op
        }
    }

    private fun calculateResult() {
        val secondNumber = currentNumber.toDoubleOrNull()
        if (secondNumber != null) {
            val result = when (operation) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> if (secondNumber != 0.0) firstNumber / secondNumber else "Ошибка"
                else -> "Ошибка"
            }
            tvResult.text = result.toString()
            currentNumber = result.toString()
        } else {
            tvResult.text = "Ошибка"
        }
        operation = ""
    }

    private fun clear() {
        currentNumber = ""
        firstNumber = 0.0
        operation = ""
        tvResult.text = "0"
    }
}
