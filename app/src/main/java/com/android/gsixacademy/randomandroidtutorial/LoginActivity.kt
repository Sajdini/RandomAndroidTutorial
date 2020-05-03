package com.android.gsixacademy.randomandroidtutorial

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var mySharedPreferences: SharedPreferences?=null
    var myPreferenceseditor: SharedPreferences.Editor?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var mySharedPreferences = getSharedPreferences("RandomAndroidTutorial", Context.MODE_PRIVATE)
        if(mySharedPreferences?.contains("userName")!!){
            startActivity(Intent(applicationContext,UserSignedInActivity::class.java))
            finish()
        }
        button_sign_in.setOnClickListener {
            var userName = edit_text_username.text.toString()
            var password = edit_text_pasword.text.toString()
            mySharedPreferences.edit().putString("userName",userName).apply()
            mySharedPreferences.edit().putString("password", password).apply()

            // or you can do it like this
            //mySharedPreferences.edit().putString("userName",userName)
            //mySharedPreferences.edit().putString("password",password)
            //myPreferencesEditor?.apply()

            startActivity(Intent(applicationContext,UserSignedInActivity::class.java))
            finish()
        }
    }
}