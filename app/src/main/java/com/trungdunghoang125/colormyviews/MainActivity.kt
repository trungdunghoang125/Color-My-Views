package com.trungdunghoang125.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    private fun makeColored(view : View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundResource(randomColor())
            R.id.box_two_text -> view.setBackgroundResource(randomColor())
            R.id.box_three_text -> view.setBackgroundResource(randomColor())
            R.id.box_four_text -> view.setBackgroundResource(randomColor())
            R.id.box_five_text -> view.setBackgroundResource(randomColor())

            else -> view.setBackgroundResource(R.color.platinum)
        }
    }

    private fun setListener() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val resetButton = findViewById<Button>(R.id.reset_button)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableView: List<View> = listOf(boxOneText, boxTwoText, boxThreeText,
                                                boxFourText,boxFiveText, rootConstraintLayout)
        for (item in clickableView) {
            item.setOnClickListener { makeColored(it) }
        }
        resetButton.setOnClickListener {
            resetColor()
        }
    }

    private fun randomColor(): Int {
        return when ((1..6).random()) {
            1 -> R.color.lavender_pink
            2 -> R.color.dark_pastel_purple
            3 -> R.color.topaz
            4 -> R.color.little_boy_blue
            5 -> R.color.baby_blue_eyes

            else -> R.color.platinum
        }
    }

    private fun resetColor() {
        findViewById<TextView>(R.id.box_one_text).setBackgroundResource(R.color.white)
        findViewById<TextView>(R.id.box_two_text).setBackgroundResource(R.color.white)
        findViewById<TextView>(R.id.box_three_text).setBackgroundResource(R.color.white)
        findViewById<TextView>(R.id.box_four_text).setBackgroundResource(R.color.white)
        findViewById<TextView>(R.id.box_five_text).setBackgroundResource(R.color.white)
        findViewById<View>(R.id.constraint_layout).setBackgroundResource(R.color.white)
    }
}