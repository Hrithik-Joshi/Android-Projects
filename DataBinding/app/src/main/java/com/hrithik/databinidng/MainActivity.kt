package com.hrithik.databinidng

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hrithik.databinidng.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var name: TextView
    private lateinit var time: TextView
    private lateinit var enterText: EditText
    private lateinit var clear:Button
    private lateinit var binding:ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val startTime = System.nanoTime()

//        button = findViewById(R.id.buttonView)
//        enterText = findViewById(R.id.editTextView)
//        name = findViewById(R.id.textView)
//        time = findViewById(R.id.timeView)
//        clear = findViewById(R.id.buttonView2)

        val endTime = System.nanoTime()
        val timeTaken = (endTime - startTime) / 1000000

        binding.buttonView.setOnClickListener {
            val text: String = binding.editTextView.text.toString()
            binding.textView.text = text
            binding.timeView.text = "Time taken: $timeTaken"
        }


        binding.buttonView2.setOnClickListener{
            binding.textView.text=""
            binding.timeView.text=""
            binding.editTextView.text.clear()
        }

    }
}

















