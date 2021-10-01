package com.example.detailapplication.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdul.firstapp.WordsAdapter
import com.example.detailapplication.R

class RecyclerActivity : AppCompatActivity(){
    lateinit var wordsRecyclerView: RecyclerView
    var words = arrayOf("Muhammad Khateeb","Idris Adil","Abdullah Mohammad", "Osama Alatssi")

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        wordsRecyclerView = findViewById(R.id.recycler_view)
        var adapter = WordsAdapter(words)
        wordsRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}