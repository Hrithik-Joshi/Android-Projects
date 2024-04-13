package com.hrithik.livedataapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingNum: Int) : ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalSum: LiveData<Int>
        get() = total

    init {
        total.value = startingNum
    }

    fun addSum(input: Int) {
        total.value = (total.value)?.plus(input)
    }

}