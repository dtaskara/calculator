package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private var res = false
    private var firstNum = ""
    private var output: Int = 0
    private var secondNum = ""
    private var displayText: String = ""
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }


    private fun initUI() {
        setActions()
    }

    private fun setDisplayText(isResult: Boolean) {
        if (isResult) {
            text.text = output.toString()
            res = true
            firstNum = output.toString()
            secondNum = ""
            operator = ""
        } else
            text.text = firstNum + operator + secondNum
    }

    private fun setNumber(number: String) {
        Log.d("mhm", "hello " + res)
        if (res && operator.equals("")) {
            Log.d("mhm", "inside condition")
            firstNum = ""
            res = false
        }
        if (!operator.equals("")) {
            secondNum += number
        } else
            firstNum = firstNum + number
        setDisplayText(false)
    }

    private fun setOperation(op: String) {

        if (!firstNum.isEmpty() && secondNum.isEmpty()) {
            operator = op
            setDisplayText(false)
        }

    }


    private fun setActions() {
        one.setOnClickListener {
            setNumber("1")
        }
        two.setOnClickListener {
            setNumber("2")
        }
        three.setOnClickListener {
            setNumber("3")
        }
        four.setOnClickListener {
            setNumber("4")
        }
        five.setOnClickListener {
            setNumber("5")
        }
        six.setOnClickListener {
            setNumber("6")
        }
        seven.setOnClickListener {
            setNumber("7")
        }
        eight.setOnClickListener {
            setNumber("8")
        }
        nine.setOnClickListener {
            setNumber("9")
        }
        zero.setOnClickListener {
            setNumber("0")
        }
        plus.setOnClickListener {
            setOperation("+")
        }
        reduce.setOnClickListener {
            setOperation("-")
        }
        multiply.setOnClickListener {
            setOperation("*")
        }
        divide.setOnClickListener {
            setOperation("/")
        }
        equal.setOnClickListener {
            operatorFunc()
        }
        c.setOnClickListener {
            firstNum = ""
            secondNum = ""
            operator = ""
            setDisplayText(false)
        }
    }

    private fun operatorFunc() {
        if (secondNum.isNotEmpty() && !operator.equals("") && !firstNum.equals(""))
            when (operator) {
                "+" -> {
                    output = firstNum.toInt() + secondNum.toInt()
                    setDisplayText(true)
                }
                "-" -> {
                    output = firstNum.toInt() - secondNum.toInt()
                    setDisplayText(true)
                }
                "/" -> {
                    if (secondNum.toInt() == 0) {
                        text.text = "Error"
                        firstNum = ""
                        secondNum = ""
                        operator = ""
                    } else {
                        output = firstNum.toInt() / secondNum.toInt()
                        setDisplayText(true)
                    }

                }
                "*" -> {
                    output = firstNum.toInt() * secondNum.toInt()
                    setDisplayText(true)
                }
            }

    }

}
