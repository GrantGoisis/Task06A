package com.example.task06a

class ButtonGame {
    var counter: Int = 0

    fun buttonPressed(oper: Char): Unit {
        when (oper) {
            'p' -> counter = counter + 1
            'm' -> counter = counter - 1
        }
    }
}