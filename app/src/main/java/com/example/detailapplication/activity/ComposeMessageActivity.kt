package com.example.detailapplication.activity

import androidx.appcompat.app.AppCompatActivity
import com.example.detailapplication.R

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


