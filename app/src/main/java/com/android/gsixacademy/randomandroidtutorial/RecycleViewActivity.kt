package com.android.gsixacademy.randomandroidtutorial

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity: AppCompatActivity() {
    var listActivities: ArrayList<String> = arrayListOf("RelativeLayoutActivity","CalculatorActivity","TodoListActivity")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        var activitiesAdapter:ActivitiesAdapter= ActivitiesAdapter(listActivities)
        recycler_view_activities.adapter=activitiesAdapter

        }

    }

