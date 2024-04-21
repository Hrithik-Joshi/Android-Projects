package com.hrithik.conactmanager.viewModel

import android.view.View
import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hrithik.conactmanager.room.UserRepository

class UserViewModelFactory(private val repo:UserRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}