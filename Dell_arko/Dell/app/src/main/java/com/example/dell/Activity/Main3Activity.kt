package com.example.dell.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.dell.R

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        var btn_new_activity = findViewById(R.id.loginButton) as Button
        var mEditTextEmail = findViewById<EditText>(R.id.edit_text_email) as EditText



        btn_new_activity.setOnClickListener {
            val intent = Intent(this@Main3Activity, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            //intent.putExtra("Organization", organization)
            startActivity(intent)
        }
    }
}
