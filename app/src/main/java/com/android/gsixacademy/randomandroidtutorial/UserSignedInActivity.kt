package com.android.gsixacademy.randomandroidtutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_signed_in.*

class UserSignedInActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_signed_in)
        var mySharedPreferences = getSharedPreferences("RandomAndroidTutorial", Context.MODE_PRIVATE)

        var userName:String?=mySharedPreferences.getString("userName","/")

        text_view_tittle.text="Signed in User is $userName"

    //   if (mySharedPreferences.contains(userName)) {
         button_log_out.setOnClickListener {
           //  mySharedPreferences.edit().remove("userName")
             mySharedPreferences.edit().clear().apply()
               onBackPressed()
               // startActivity(Intent(applicationContext, LoginActivity::class.java))
          }
     //   }else {
            //   Toast.makeText(applicationContext,"There is no user signed in",Toast.LENGTH_LONG).show()
            }
        }






