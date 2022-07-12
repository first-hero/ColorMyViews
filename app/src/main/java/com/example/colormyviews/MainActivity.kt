package com.example.colormyviews

import android.graphics.Color

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // binding.playInfoText.text = "Click buttons, background and text boxes to change colors or RESET button to reset colors\nHere are some ideas:\n- Use images instead of colors, and reveal the images. \n - You can even create a picture memory game! \n - Use one image and break it up into sections to reveal over time.\n - Get rid of the text and buttons and just fill the screen with boxes. Implement one of Piet Mondrian's Paintings!\n - Take the AboutMe app and remake it using ConstraintLayout with a more creative arrangement of information\n - Style the app to uniquely represent you and your personality."

        setListeners()
        resetColors()

    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(
                binding.boxOneText,
                binding.boxTwoText,
                binding.boxThreeText,
                binding.boxFourText,
                binding.boxFiveText,
                binding.constraintLayout,
                binding.redButton, binding.greenButton, binding.yellowButton
            )
        for (item in clickableViews) {
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View) {
        when (view) {

            // Boxes using Color class colors for background
            binding.boxOneText -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            binding.boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

            binding.redButton -> binding.boxThreeText.setBackgroundResource(R.color.red)
            binding.greenButton-> binding.boxFourText.setBackgroundResource(R.color.green)
            binding.yellowButton -> binding.boxFiveText.setBackgroundResource (R.color.yellow)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun resetColors() {
        binding.button.setOnClickListener {
            binding.boxOneText.setBackgroundColor(resources.getColor(R.color.purple_500))
            binding.boxTwoText.setBackgroundColor(resources.getColor(R.color.purple_500))
            binding.boxThreeText.setBackgroundColor(resources.getColor(R.color.purple_500))
            binding.boxFourText.setBackgroundColor(resources.getColor(R.color.purple_500))
            binding.boxFiveText.setBackgroundColor(resources.getColor(R.color.purple_500))
            binding.constraintLayout.setBackgroundColor(Color.WHITE)
        }
    }

}