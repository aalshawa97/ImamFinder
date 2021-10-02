package com.example.detailapplication.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.detailapplication.R

class ComposeMessageActivity : AppCompatActivity()
{
    private fun AppCompatActivity.onCreate() {
        //Bundle outState
        //super.onSaveInstanceState(outState);
        val savedInstanceState = null
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        val i = getIntent()
        val name = i.getStringExtra("NAME")
        if(name == null)
            Toast.makeText(this,"Composing Message", Toast.LENGTH_LONG).show()
    }
}


