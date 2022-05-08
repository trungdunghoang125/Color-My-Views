package com.trungdunghoang125.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    fun makeColored(view : View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundResource(android.R.color.holo_red_light)
            R.id.box_two_text -> view.setBackgroundResource(android.R.color.holo_orange_light)
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_blue_bright)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_purple)

            else -> view.setBackgroundResource(android.R.color.darker_gray)
        }
    }

    private fun setListener() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableView: List<View> = listOf(boxOneText, boxTwoText, boxThreeText,
                                                boxFourText,boxFiveText, rootConstraintLayout)
        for (item in clickableView) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}