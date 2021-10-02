package com.example.detailapplication.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.detailapplication.R
import com.example.detailapplication.room.Imam
import com.example.detailapplication.room.WordListAdapter
import com.example.detailapplication.room.WordViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Observer

class ImamMainActivity : AppCompatActivity() {
    private val newWordActivityRequestCode = 1
    private lateinit var wordViewModel: WordViewModel
    var words = arrayOf("Muhammad Khateeb","Idris Adil","Abdullah Mohammad", "Osama Alatssi")
    lateinit var wordsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        wordsRecyclerView =  findViewById<RecyclerView>(R.id.recycler_view)
        //var adapter = WordListAdapter(words)
        wordsRecyclerView.layoutManager = LinearLayoutManager(this)

        setContentView(R.layout.activity_recycler)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        //setSupportActionBar(toolbar)

       val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

       val adapter = WordListAdapter(this)

       recyclerView.adapter = adapter
       recyclerView.layoutManager = LinearLayoutManager(this)

       // Get a new or existing ViewModel from the ViewModelProvider.
       //wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

       // Add an observer on the LiveData returned by getAlphabetizedWords.
       // The onChanged() method fires when the observed data changes and the activity is
       // in the foreground.
        /*
       wordViewModel.allWords.observe(this, Observer { words ->
           // Update the cached copy of the words in the adapter.
           words?.let { adapter.setWords(it) }
       })
        pagedListLiveData.observe(lifeCycleOwner, android.arch.lifecycle.Observer{
            adapter.submitList(it)
        })
        */
        /*
       val fab = findViewById<FloatingActionButton>(R.id.fab)
       fab.setOnClickListener {
           val intent = Intent(this@ImamMainActivity, NewWordActivity::class.java)
           startActivityForResult(intent, newWordActivityRequestCode)
       }*/

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val word = Imam(NewWordActivity.EXTRA_REPLY)
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}