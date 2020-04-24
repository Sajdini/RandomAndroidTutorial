package com.android.gsixacademy.randomandroidtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity: AppCompatActivity() {
    var listCars: ArrayList<String> = arrayListOf("McLaren","Jaguar","Audi","Honda")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        var carsAdapter:CarsAdapter= CarsAdapter(listCars)
        recycler_view_activities.adapter=carsAdapter

        }

    }

