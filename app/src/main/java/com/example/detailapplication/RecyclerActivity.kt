package com.example.detailapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdul.firstapp.WordsAdapter

class RecyclerActivity : AppCompatActivity(){
    lateinit var wordsRecyclerView: RecyclerView
    var words = arrayOf("Muhammad Khateeb","Idris Adil","Abdullah Mohammad", "Osama Alatssi")

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        wordsRecyclerView = findViewById(R.id.wordsRecyclerview)
        var adapter = WordsAdapter(words)
        wordsRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}