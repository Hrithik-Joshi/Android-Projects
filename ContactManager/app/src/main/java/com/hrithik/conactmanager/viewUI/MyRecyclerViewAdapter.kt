package com.hrithik.conactmanager.viewUI

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrithik.conactmanager.databinding.CardItemBinding
import com.hrithik.conactmanager.room.User

class MyRecyclerViewAdapter(
    private val userList: List<User>,
    private val clickListener: (User) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
class MyViewHolder(private val binding:CardItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(user:User, clickListener: (User) -> Unit){
        binding.nameTextView.text=user.name
        binding.emailTextView.text=user.email

        binding.ListItem.setOnClickListener{
            clickListener(user)
        }
    }
}