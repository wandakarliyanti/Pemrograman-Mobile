package com.example.modul2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.modul2.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val cost = binding.costOfService.text.toString().toDouble()
        val selectedID = binding.radioOption.checkedRadioButtonId
        val tipPercentage = when(selectedID){
            R.id.radioAmazing -> 0.20
            R.id.radioGood -> 0.18
            else -> 0.15
        }

        var tip = cost*tipPercentage
        val roundUp = binding.switchRoundUp.isChecked
        if (roundUp){
           tip = ceil(tip)
        }

        val formattedTip = String.format("%.2f", tip)
        binding.tipAmount.text = getString(R.string.tip_amount, formattedTip)
    }
}