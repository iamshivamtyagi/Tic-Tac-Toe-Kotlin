package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var board: Array<Array<Button>>

    var PLAYER = true
    var TURN_COUNT = 0
    var boardStatus = Array(3) { IntArray(3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        board = arrayOf(
            arrayOf(btn1, btn2, btn3),
            arrayOf(btn4, btn5, btn6),
            arrayOf(btn7, btn8, btn9)
        )

        for (i in board) {
            for (button in i)
                button.setOnClickListener(this)
        }

        initializeBoardStatus()

        resetBtn.setOnClickListener {
            PLAYER = true
            TURN_COUNT = 0
            initializeBoardStatus()
        }
    }

    private fun initializeBoardStatus() {
        for (i in 0..2) {
            for (j in 0..2) {
                boardStatus[0][0] == -1
                board[0][0].isEnabled = true
                board[0][0].text = ""
            }
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.btn1 -> {
                    updateValue(row = 0, col = 0, player = PLAYER)
                }
                R.id.btn2 -> {
                    updateValue(row = 0, col = 1, player = PLAYER)
                }
                R.id.btn3 -> {
                    updateValue(row = 0, col = 2, player = PLAYER)
                }
                R.id.btn4 -> {
                    updateValue(row = 1, col = 0, player = PLAYER)
                }
                R.id.btn5 -> {
                    updateValue(row = 1, col = 1, player = PLAYER)
                }
                R.id.btn6 -> {
                    updateValue(row = 1, col = 2, player = PLAYER)
                }
                R.id.btn7 -> {
                    updateValue(row = 2, col = 0, player = PLAYER)
                }
                R.id.btn8 -> {
                    updateValue(row = 2, col = 1, player = PLAYER)
                }
                R.id.btn9 -> {
                    updateValue(row = 2, col = 2, player = PLAYER)
                }
            }
        }
        TURN_COUNT++
        PLAYER = !PLAYER

        if (PLAYER) {
            updateDisplay("Player X Turn")
        } else {
            updateDisplay("Player O Turn")
        }

        if (TURN_COUNT == 9)
            updateDisplay("Game Draw")
    }

    private fun updateDisplay(message: String) {
        displayTv.text = message
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        val text: String = if (player) "X" else "O"
        val value: Int = if (player) 1 else 0

        board[row][col].apply {
            isEnabled = false
            setText(text)
        }

        boardStatus[row][col] = value
    }

}
