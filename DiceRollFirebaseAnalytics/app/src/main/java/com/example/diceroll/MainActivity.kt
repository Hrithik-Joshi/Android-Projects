package com.example.diceroll

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.diceroll.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.analytics.logEvent
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val builder = AlertDialog.Builder(this)
        firebaseAnalytics = Firebase.analytics
        binding.fab.setOnClickListener {
            builder.setMessage("Select Your Experience")
                .setPositiveButton("Noob") { dialog, id ->
                    firebaseAnalytics.setUserProperty("experience_level", "Noob")
                    dialog.cancel();
                }
                .setNegativeButton("Pro") { dialog, id ->
                    firebaseAnalytics.setUserProperty("experience_level", "Pro")
                    dialog.cancel();
                }
            // Create the AlertDialog object and return it.
            builder.create().show()
        }
        binding.buttonFirst.setOnClickListener {
            onDiceRolled();
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onDiceRolled() {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(drawableResource)
        val str1: String = "Dice Value "
        binding.value.text = str1.plus(randomInt)
        val bundle = Bundle()
        bundle.putString("diceValue", randomInt.toString())
        firebaseAnalytics.logEvent("DiceNumber", bundle)
    }
}