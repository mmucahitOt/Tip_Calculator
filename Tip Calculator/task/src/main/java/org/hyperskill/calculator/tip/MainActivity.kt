package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billEditText = findViewById<EditText>(R.id.edit_text)
        val tipPercentageSlider = findViewById<Slider>(R.id.slider)
        val resultTextView = findViewById<TextView>(R.id.text_view)


        billEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                s?.toString() ?: ""
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == "") {
                    resultTextView.text = ""
                } else {
                    val bill = s.toString().toFloat()
                    val tipPercentage = tipPercentageSlider.value
                    val tip = bill * tipPercentage / 100
                    resultTextView.text = "Tip amount: ${"%.2f".format(tip)}"
                }
            }
        })

        tipPercentageSlider.addOnChangeListener { _, value, _ ->

            if (billEditText.text.toString() == "") {
                resultTextView.text = ""
            } else {
                val billText = billEditText.text.toString()
                val tipPercentageText = tipPercentageSlider.value
                val tip = billText.toFloat() * tipPercentageText / 100
                resultTextView.text = "Tip amount: ${"%.2f".format(tip)}"
            }
        }
    }

}