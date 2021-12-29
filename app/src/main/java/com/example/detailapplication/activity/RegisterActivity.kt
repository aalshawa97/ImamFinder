package com.example.detailapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.detailapplication.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun onClick(view: android.view.View)
    {
        Toast.makeText(this, "Registering user", Toast.LENGTH_LONG)
        Log.d("Registering user", "onClick: ")
    }
}