package com.example.detailapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComposeMessageActivity : AppCompatActivity()
{
    private fun AppCompatActivity.onCreate() {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        val i = getIntent()
        val name = i.getStringExtra("NAME")
        if(name == null)
        {
            //((TextView())findViewById(R.id.textView)).setText("Composing Message")
        }
    }
}


