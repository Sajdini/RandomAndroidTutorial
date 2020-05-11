package com.android.gsixacademy.randomandroidtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.gsixacademy.randomandroidtutorial.movies.PopularMoviesActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_todo_list_layout.*

class MainActivity : AppCompatActivity() {
    var listActivities: ArrayList<String> = arrayListOf("RelativeLayoutActivity","CalculatorActivity","TodoListActivity","RecycleViewActivity", "LoginActivity","UserSignedInActivity","PopularMoviesActivity")
    //this is the list that shows the Activities we acces from Main activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Picasso.get().load("https://www.soder.com/assets/images/3/maybach-pullman650-2-6ea118f9.JPG").fit().into(image_view_background)

        var activitiesAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listActivities)
        list_view_activities.adapter = activitiesAdapter
        //this is a normal adapted
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
                "LoginActivity"->startActivity(Intent(applicationContext,LoginActivity::class.java))
                "UserSignedInActivity"->startActivity(Intent(applicationContext,UserSignedInActivity::class.java))
                "PopularMoviesActivity"->startActivity(Intent(applicationContext,PopularMoviesActivity::class.java))

            }
            //this is the setOnItem ClickListener for the mainactivity
            Toast.makeText(applicationContext,className,Toast.LENGTH_LONG).show()
        }

    }
}
