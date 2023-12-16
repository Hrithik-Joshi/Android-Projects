package com.example.vaccineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1- Adapter View: Recycler View
        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //2- Data Source
        var vaccineList:ArrayList<VaccineModel> = ArrayList()
        val v1=VaccineModel("Covid-19",R.drawable.vaccine1)
        val v2=VaccineModel("Hepatitus B",R.drawable.vaccine4)
        val v3=VaccineModel("Tatanus Vaccine",R.drawable.vaccine5)
        val v4=VaccineModel("Bharat Vaccine",R.drawable.vaccine6)
        val v10=VaccineModel("Covishield",R.drawable.vaccine7)
        val v5=VaccineModel("Covaxcine",R.drawable.vaccine8)
        val v6=VaccineModel("chickenpox Vaccine",R.drawable.vaccine8)
        val v7=VaccineModel("measles Vaccine",R.drawable.vaccine1)
        val v8=VaccineModel("Pharmaceutical vaccine",R.drawable.vaccine4)
        val v9=VaccineModel("Rotavirus Vaccine",R.drawable.vaccine7)
        vaccineList.add(v1)
        vaccineList.add(v2)
        vaccineList.add(v3)
        vaccineList.add(v4)
        vaccineList.add(v5)
        vaccineList.add(v6)
        vaccineList.add(v7)
        vaccineList.add(v8)
        vaccineList.add(v9)
        vaccineList.add(v10)

        //3- Adapter
        val myAdapter=MyAdapter(vaccineList)
        recyclerView.adapter=myAdapter
    }
}