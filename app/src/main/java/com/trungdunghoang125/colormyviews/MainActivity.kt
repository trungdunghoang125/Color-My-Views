package com.trungdunghoang125.colormyviews

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

            R.id.red_button -> findViewById<TextView>(R.id.box_three_text).setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> findViewById<TextView>(R.id.box_four_text).setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> findViewById<TextView>(R.id.box_five_text).setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundResource(android.R.color.darker_gray)
        }
    }

    private fun setListener() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val redButton = findViewById<Button>(R.id.red_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)
        val greenButton = findViewById<Button>(R.id.green_button)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableView: List<View> = listOf(boxOneText, boxTwoText, boxThreeText,
                                                boxFourText,boxFiveText, rootConstraintLayout,
                                                redButton, yellowButton, greenButton)
        for (item in clickableView) {
            item.setOnClickListener { makeColored(it) }
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
}