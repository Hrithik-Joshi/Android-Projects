package com.hrithik.livedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hrithik.livedataapp.databinding.ActivityMainBinding
import com.hrithik.livedataapp.viewModel.MainActivityViewModel
import com.hrithik.livedataapp.viewModel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModelFactory = MainActivityViewModelFactory(200)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainActivityViewModel::class.java)

        // observing live data
        viewModel.totalSum.observe(this,
            Observer {
                binding.textView.text = it.toString()
            })

        binding.button.setOnClickListener {
            viewModel.addSum(binding.editText.text.toString().toInt())
        }

    }
}