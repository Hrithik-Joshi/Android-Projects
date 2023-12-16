package com.example.lucky_number

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var username: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        username = findViewById(R.id.user_name)
        btn.isEnabled = false

        username.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed for this implementation
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Check if the EditText has text and enable or disable the button accordingly
                btn.isEnabled = s?.isNotBlank() == true
            }

            override fun afterTextChanged(s: Editable?) {
                // Check if the EditText is empty and disable the button if it is
                btn.isEnabled = s?.isNotBlank() == true
            }
        })

        btn.setOnClickListener {
            val uName = username.text.toString()

            // Explicit Intents
            val i = Intent(this, LuckyNumberActivity::class.java)
            i.putExtra("key-name", uName)
            startActivity(i)
        }

    }
}