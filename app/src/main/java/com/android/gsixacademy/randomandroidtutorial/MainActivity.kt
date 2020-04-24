package com.android.gsixacademy.randomandroidtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_todo_list_layout.*

class MainActivity : AppCompatActivity() {
    var listActivities: ArrayList<String> = arrayListOf("RelativeLayoutActivity","CalculatorActivity","TodoListActivity","RecycleViewActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var activitiesAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listActivities)
        list_view_activities.adapter = activitiesAdapter
        list_view_activities.setOnItemClickListener { adapterView, view, i, l ->
            var className = listActivities[i]
            when (className) {
                //this is the relative layout
                "RelativeLayoutActivity" -> startActivity(Intent(applicationContext, RelativeLayoutActivity::class.java))
                //this is the calculator
                "CalculatorActivity"->startActivity(Intent(applicationContext, CalculatorActivity::class.java))
                //this is the to do list
                "TodoListActivity"  -> startActivity(Intent(applicationContext, ToDoListActivity::class.java))
                "RecycleViewActivity"-> startActivity(Intent(applicationContext, RecycleViewActivity::class.java))
            }
            Toast.makeText(applicationContext,className,Toast.LENGTH_LONG).show()
        }

    }
}
