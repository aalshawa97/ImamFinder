package com.example.detailapplication.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.detailapplication.room.WordListAdapter
import com.example.detailapplication.R

class RecyclerActivity : AppCompatActivity(){
    lateinit var wordsRecyclerView: RecyclerView
    var words = arrayOf("Muhammad Khateeb","Idris Adil","Abdullah Mohammad", "Osama Alatssi")

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        wordsRecyclerView = findViewById(R.id.recycler_view)
        var image: ImageView = findViewById(R.id.imageViewImam)
        image.setImageResource(R.drawable._200px_ismail_ibn_musa_menks_talk_at_kerala_state_business_excellence_awards_2015)
        setContentView(image)
        //var adapter = WordListAdapter(words)
        wordsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

}