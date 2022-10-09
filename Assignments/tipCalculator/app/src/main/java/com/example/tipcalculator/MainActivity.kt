package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.truncate
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var billTotal by Delegates.notNull<Double>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.executeTipCalculation.setOnClickListener {
        //checks to see if the bill entered is empty or not.
            if(!binding.dollarInput.text.toString().trim().isEmpty()){
                //applies tip and tip totals to their respective areas.
                var bill = binding.dollarInput.text.toString().toDouble()
                var tip = (bill * 0.1)
                var billTotal = bill+tip
                var outputTipText = String.format("%.2f",tip)
                var outputTotalText = String.format("%.2f",billTotal)
                binding.tipLabel01.visibility = View.VISIBLE
                binding.total01.visibility = View.VISIBLE
                binding.tip01.text = "$$outputTipText"
                binding.tipTotal01.text = "$$outputTotalText"
                tip = (bill * 0.15)
                billTotal = bill+tip
                outputTipText = String.format("%.2f",tip)
                outputTotalText = String.format("%.2f",billTotal)
                binding.tipLabel02.visibility = View.VISIBLE
                binding.total02.visibility = View.VISIBLE
                binding.tip02.text = "$$outputTipText"
                binding.tipTotal02.text = "$$outputTotalText"
                tip = (bill * 0.2)
                billTotal = bill+tip
                outputTipText = String.format("%.2f",tip)
                outputTotalText = String.format("%.2f",billTotal)
                binding.tipLabel03.visibility = View.VISIBLE
                binding.total03.visibility = View.VISIBLE
                binding.tip03.text = "$$outputTipText"
                binding.tipTotal03.text = "$$outputTotalText"
            } else{
                //handles the error if the input is null. Clears out the input and all display labels.
                binding.dollarInput.text.clear()
                binding.tip01.text = ""
                binding.tip02.text = ""
                binding.tip03.text = ""
                binding.tipTotal01.text = ""
                binding.tipTotal02.text = ""
                binding.tipTotal03.text = ""
                binding.tipLabel01.visibility = View.INVISIBLE
                binding.total01.visibility = View.INVISIBLE
                binding.tipLabel02.visibility = View.INVISIBLE
                binding.total02.visibility = View.INVISIBLE
                binding.tipLabel03.visibility = View.INVISIBLE
                binding.total03.visibility = View.INVISIBLE
                Toast.makeText(applicationContext, "Please enter a bill amount.", Toast.LENGTH_SHORT).show()
            }

        }

    }
}

