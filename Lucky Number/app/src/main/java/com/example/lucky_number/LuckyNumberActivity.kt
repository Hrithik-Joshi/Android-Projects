package com.example.lucky_number

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)
        val headerText: TextView = findViewById(R.id.text_username)
        val luckyNum: TextView = findViewById(R.id.lucky_number)
        val shareBtn: Button = findViewById(R.id.share_btn)
        //setting username in the title
        val uname = receiveUsername()
        val header = resources.getString(R.string.header_text, "Hi ", uname)
        headerText.text = header

        //setting random number to text view
        val lNum = getRandomNumber().toString()
        luckyNum.text = lNum

        shareBtn.setOnClickListener() {
            shareData(uname, lNum)
        }
    }

    private fun receiveUsername(): String {
        val bundle: Bundle? = intent.extras
        return bundle?.get("key-name").toString()
    }

    //Random number generation
    private fun getRandomNumber(): Int {
        return Random.nextInt(100)
    }

    //Sharing the username and number
    private fun shareData(username: String, number: String) {
        // using implicit intent to share externally
        var i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is $number")
        startActivity(i)
    }
}