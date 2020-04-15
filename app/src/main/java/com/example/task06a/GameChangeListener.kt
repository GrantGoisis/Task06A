package com.example.task06a

// This interface specifies that anyone who creates a GamePlayListener object
// must provide an implementation of the onGameChanged() method.
//
// This interface could have been specified within another file, such as an Abstract class,
// but was kept separate here to aid clarity

interface GameChangeListener {
    fun onGameChange(buttonGame: ButtonGame)
}