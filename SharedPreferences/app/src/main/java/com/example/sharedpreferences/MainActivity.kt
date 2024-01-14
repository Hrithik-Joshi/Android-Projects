package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class MainActivity : AppCompatActivity() {
    lateinit var lastUsername:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username:EditText=findViewById(R.id.username)
        lastUsername=findViewById(R.id.lastUsername)
        val saveMe:Button=findViewById(R.id.button)
        saveMe.setOnClickListener(){
            val enteredText:String=username.text.toString()
            Log.d("entered",enteredText)
            saveUsernameSharedPref(enteredText)
            if (enteredText.isNotEmpty()) {
                saveUsernameSharedPref(enteredText)
                Toast.makeText(this, "Username saved", LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter a username", LENGTH_SHORT).show()
            }
        }
        displayName()

    }

    private fun saveUsernameSharedPref(enteredText: String) {
        //saving username in SPref
        val sharedPref:SharedPreferences=getSharedPreferences("Username",
        MODE_PRIVATE)

        //writing data to shared pref
        val editor:SharedPreferences.Editor=sharedPref.edit()
        editor.putString(PREF_KEY_USERNAME,enteredText)
        editor.apply()
    }

    //reading data from shared pref
    private fun displayName(){
        val sharedPref:SharedPreferences=getSharedPreferences("Username", MODE_PRIVATE)
        val displayText: String =sharedPref.getString(PREF_KEY_USERNAME,"").toString()
        Log.d("TAG",displayText)
        lastUsername.text = displayText
    }

    companion object {
        const val PREF_KEY_USERNAME = "uname"
    }
}