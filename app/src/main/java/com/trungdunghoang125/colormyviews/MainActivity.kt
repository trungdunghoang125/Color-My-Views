package com.trungdunghoang125.colormyviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.trungdunghoang125.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
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
        val boxOneText = binding.boxOneText
        val boxTwoText = binding.boxTwoText
        val boxThreeText = binding.boxThreeText
        val boxFourText = binding.boxFourText
        val boxFiveText = binding.boxFiveText

        val resetButton = binding.resetButton

        val rootConstraintLayout = binding.constraintLayout

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
        binding.boxOneText.setBackgroundResource(R.color.white)
        binding.boxTwoText.setBackgroundResource(R.color.white)
        binding.boxThreeText.setBackgroundResource(R.color.white)
        binding.boxFourText.setBackgroundResource(R.color.white)
        binding.boxFiveText.setBackgroundResource(R.color.white)
        binding.constraintLayout.setBackgroundResource(R.color.white)
    }
}