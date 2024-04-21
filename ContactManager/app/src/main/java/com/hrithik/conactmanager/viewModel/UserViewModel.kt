package com.hrithik.conactmanager.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hrithik.conactmanager.R
import com.hrithik.conactmanager.room.User
import com.hrithik.conactmanager.room.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repo: UserRepository) : ViewModel(), Observable {

    val users = repo.users
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: User

    //Bindable is used to notify UI components (like views) when the underlying data changes.
    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputEmail = MutableLiveData<String?>()

    @Bindable
    var saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearOrDeleteAllButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearOrDeleteAllButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        if (isUpdateOrDelete) {
            //make update
            userToUpdateOrDelete.name = inputName.value!!
            userToUpdateOrDelete.email = inputEmail.value!!
            update(userToUpdateOrDelete)
        } else {
            //!! not null assertion operator convert nullable type to nul null type
            val name = inputName.value!!
            val email = inputEmail.value!!

            insert(User(0, name, email))
            inputName.value = null
            inputEmail.value = null
        }
    }

    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(userToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    private fun insert(user: User) = viewModelScope.launch {
        repo.insert(user)
    }

    private fun update(user: User) = viewModelScope.launch {
        repo.update(user)

        //resetting the fields and button
        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        clearOrDeleteAllButtonText.value = "Clear All"
    }

    private fun delete(user: User) = viewModelScope.launch {
        repo.delete(user)

        //resetting the fields and button
        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        clearOrDeleteAllButtonText.value = "Clear All"
    }

    private fun clearAll() = viewModelScope.launch {
        repo.deleteAll()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    fun initUpdateAndDelete(selectedItem: User) {
        inputEmail.value = selectedItem.email
        inputName.value = selectedItem.name
        isUpdateOrDelete = true
        userToUpdateOrDelete = selectedItem
        saveOrUpdateButtonText.value = "Update"
        clearOrDeleteAllButtonText.value = "Delete"
    }

}