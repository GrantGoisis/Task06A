package com.example.task06a

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.Typeface
import android.graphics.Color

class BoardView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

//circle and text colors
    private val plusCol: Int = Color.RED
    private val minusCol: Int = Color.YELLOW
    private val backCol: Int = Color.argb(100,128,255,0 )
    private val textCol: Int = Color.BLACK

    //paint variables
    private var plusPaint: Paint
    private var backPaint: Paint
    private var minusPaint: Paint
    private var wordsPaint: Paint

    init {
        //paint object for drawing circles in onDraw -- also configure it
        plusPaint = Paint().apply {
            setStyle(Paint.Style.FILL)
            setAntiAlias(true)
            //set the paint color using the circle color specified
            setColor(plusCol)
        }

        backPaint = Paint().apply {
            // Set up the paint style
            setStyle(Paint.Style.FILL)
            setColor(backCol)
        }

        minusPaint = Paint().apply {
            setStyle(Paint.Style.FILL)
            setAntiAlias(true)
            setColor(minusCol)
        }

        wordsPaint = Paint().apply {
            setColor(textCol)
            //set text properties
            setTextAlign(Paint.Align.CENTER)
            setTextSize(200.toFloat())
            setTypeface(Typeface.SANS_SERIF)
        }
    }

    // Add black canvas -> overrides the onDraw method.
    override fun onDraw(canvas: Canvas) {
        //draw the View -> background color.
        // Measure the size of the canvas, we could take into account padding here
        val canvasWidth = width.toFloat()
        val canvasHeight = height.toFloat()

        //get half of the width and height to locate the centre of the screen
        val viewWidthHalf = canvasWidth / 2f
        val viewHeightThird = canvasHeight / 3f

        // Background
        canvas.drawRect(0f, 0f, canvasWidth, canvasHeight, backPaint)

        // Now we're going to draw the counter value at the top.
        // For now we will just display the value 0.
        // Retrieve the value of score from the game class
        val score = 0.toString()

        canvas.drawText(score, viewWidthHalf, 200f, wordsPaint)

        // 2 Circles
        val radius: Float = viewWidthHalf/3

        canvas.drawCircle(viewWidthHalf, viewHeightThird, radius, plusPaint)
        canvas.drawText("+", viewWidthHalf, viewHeightThird, wordsPaint)

        canvas.drawCircle(viewWidthHalf, viewHeightThird*2, radius, minusPaint)
        canvas.drawText("-", viewWidthHalf, (viewHeightThird*2), wordsPaint)
    }

}