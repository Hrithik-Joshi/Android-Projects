package com.hrithik.conactmanager.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hrithik.conactmanager.room.User
import com.hrithik.conactmanager.room.UserRepository

class UserViewModel(private val repo:UserRepository):ViewModel(),Observable {

    val users = repo.users
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete : User

    //Bindable is used to notify UI components (like views) when the underlying data changes.
    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

}