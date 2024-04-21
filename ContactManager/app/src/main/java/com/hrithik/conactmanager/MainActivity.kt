package com.hrithik.conactmanager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrithik.conactmanager.databinding.ActivityMainBinding
import com.hrithik.conactmanager.room.User
import com.hrithik.conactmanager.room.UserDatabase
import com.hrithik.conactmanager.room.UserRepository
import com.hrithik.conactmanager.viewModel.UserViewModel
import com.hrithik.conactmanager.viewModel.UserViewModelFactory
import com.hrithik.conactmanager.viewUI.MyRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //Room database
        val dao = UserDatabase.getInstance(application).userDao
        val repo = UserRepository(dao)
        val factory = UserViewModelFactory(repo)

        userViewModel = ViewModelProvider(
            this,
            factory
        )[userViewModel::class.java]

        binding.userViewModel = userViewModel

        binding.lifecycleOwner = this
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        displayUserList()
    }

    private fun listItemClicked(selectedItem: User) {
        Toast.makeText(this, "Selected name is ${selectedItem.name}", Toast.LENGTH_LONG).show()

        userViewModel.initUpdateAndDelete(selectedItem)
    }

    private fun displayUserList(){
        userViewModel.users.observe(this) {
            binding.recyclerView.adapter = MyRecyclerViewAdapter(
                it
            ) { selectedItem: User -> listItemClicked(selectedItem) }
        }
    }
}