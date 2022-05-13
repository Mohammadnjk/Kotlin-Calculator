package com.kotlin.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var selectOpreator = ""
    var oldNumberOperation = ""
    var isNewOpration = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickButton(view: View) {
        if (isNewOpration) {

            clearNumber()
        }
        isNewOpration = false
        var selectButton = view as Button
        var showNumber = findViewById<EditText>(R.id.shownumber)
        var currentNumber: String = showNumber.text.toString()
        var newNumber = setNextCurracture(currentNumber, selectButton)
        showNumber.setText(newNumber)
    }

    fun clearNumber() {
        var showNumber2 = findViewById<EditText>(R.id.shownumber)
        showNumber2.setText("0")
    }

    fun setNextCurracture(oldNumber: String, selectButton: Button): String {
        var number = oldNumber
        var btn_zero = findViewById<Button>(R.id.bt0)
        var btn_1 = findViewById<Button>(R.id.bt1)
        var btn_2 = findViewById<Button>(R.id.bt2)
        var btn_3 = findViewById<Button>(R.id.bt3)
        var btn_4 = findViewById<Button>(R.id.bt4)
        var btn_5 = findViewById<Button>(R.id.bt5)
        var btn_6 = findViewById<Button>(R.id.bt6)
        var btn_7 = findViewById<Button>(R.id.bt7)
        var btn_8 = findViewById<Button>(R.id.bt8)
        var btn_9 = findViewById<Button>(R.id.bt9)
        var btn_dot = findViewById<Button>(R.id.btdot)
        var btn_sing = findViewById<Button>(R.id.bt_sing)
        var btn_c = findViewById<Button>(R.id.btc)

        when (selectButton.id) {

            btn_zero.id -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    number += "0"
                }
            }
            btn_1.id -> {
                if (number == "0" || number == "") {
                    number = "1"
                } else {
                    number += "1"
                }
            }
            btn_2.id -> {
                if (number == "0" || number == "") {
                    number = "2"
                } else {
                    number += "2"
                }
            }
            btn_3.id -> {
                if (number == "0" || number == "") {
                    number = "3"
                } else {
                    number += "3"
                }
            }
            btn_4.id -> {
                if (number == "0" || number == "") {
                    number = "4"
                } else {
                    number += "4"
                }
            }
            btn_5.id -> {
                if (number == "0" || number == "") {
                    number = "5"
                } else {
                    number += "5"
                }
            }
            btn_6.id -> {
                if (number == "0" || number == "") {
                    number = "6"
                } else {
                    number += "6"
                }
            }
            btn_7.id -> {
                if (number == "0" || number == "") {
                    number = "7"
                } else {
                    number += "7"
                }
            }
            btn_8.id -> {
                if (number == "0" || number == "") {
                    number = "8"
                } else {
                    number += "8"
                }
            }
            btn_9.id -> {
                if (number == "0" || number == "") {
                    number = "9"
                } else {
                    number += "9"
                }
            }

            btn_dot.id -> {
                if (number == "") {
                    number = "0."
                } else {

                    if (number.indexOf('.') == -1) {
                        number += "."
                    }
                }
            }

            btn_sing.id -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    if (number.first() == '-') {
                        number = number.substring(1, number.lastIndex + 1)
                    } else {
                        number = "-$number"
                    }
                }
            }
            btn_c.id -> {
                if (number == "") {
                    number = "0"
                    var text = "not yet number"
                    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
                } else {
                    number = "0"
                }
            }


        }
        return number


    }

    fun operationEvent(view: View) {
        val selectButton = view as Button
        val showNumberOpration = findViewById<EditText>(R.id.shownumber)
        var btn_divid = findViewById<Button>(R.id.bt_divid)
        var btn_zarb = findViewById<Button>(R.id.bt_zarb)
        var btn_mines = findViewById<Button>(R.id.bt_mines)
        var btn_plus = findViewById<Button>(R.id.bt_plus)

        when (selectButton.id) {
            btn_divid.id -> {
                selectOpreator = "/"
            }
            btn_zarb.id -> {
                selectOpreator = "*"

            }
            btn_mines.id -> {
                selectOpreator = "-"

            }
            btn_plus.id -> {
                selectOpreator = "+"

            }

        }
        isNewOpration = true
        oldNumberOperation = showNumberOpration.text.toString()
    }

    fun eqaulEvent(view: View) {

        view as Button
        var showNumberEqual = findViewById<EditText>(R.id.shownumber)
        var newNumberOperation = showNumberEqual.text.toString().toDouble()
        var answer: Double? = null
        if (selectOpreator != "" && oldNumberOperation != "") {
            when (selectOpreator) {
//                اینطوری هم میشه فقط تبدیل شده به دابل
                "" -> {
                    answer = newNumberOperation
                }
                "/" -> {
                    answer = oldNumberOperation.toDouble() / newNumberOperation
                }
                "*" -> {
                    answer = oldNumberOperation.toDouble() * newNumberOperation

                }
                "-" -> {
                    answer = oldNumberOperation.toDouble() - newNumberOperation

                }
                "+" -> {
                    answer = oldNumberOperation.toDouble() + newNumberOperation

                }

            }
            var showNumbrEnd = findViewById<EditText>(R.id.shownumber)
            showNumbrEnd.setText(answer.toString())
            isNewOpration = true
            selectOpreator = ""
            oldNumberOperation = ""
        }
    }

    fun perecentageEvent(view: View) {
        view as Button
        var showNumberDarsad = findViewById<EditText>(R.id.shownumber)
        val number = showNumberDarsad.text.toString().toDouble()
        val perecentage = number / 100
        showNumberDarsad.setText(perecentage.toString())
        isNewOpration = true
    }
}