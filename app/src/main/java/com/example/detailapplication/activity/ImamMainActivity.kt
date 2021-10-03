package com.example.detailapplication.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import com.example.detailapplication.ImamDao
import com.example.detailapplication.R
import com.example.detailapplication.room.Imam
import com.example.detailapplication.room.WordListAdapter
import com.example.detailapplication.room.WordViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Observer


class ImamMainActivity : AppCompatActivity() {
    private val newWordActivityRequestCode = 1
    var imam = Imam("Idris Akbar")
    var imamList = listOf<Imam>(imam)
    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        ButterKnife.bind(this)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = WordListAdapter(this)


        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        if(adapter != null)
        {
            //recyclerView.adapter = adapter
            //recyclerView.layoutManager = LinearLayoutManager(this)

            // Get a new or existing ViewModel from the ViewModelProvider.
            //wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)


            //adapter.setWords(imamList)
        }
        /*
        wordViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.setWords(it) }
        })
        */

        val fab = findViewById<FloatingActionButton>(R.id.fabData)

        /*
        fab.setOnClickListener {
            val intent = Intent(this, NewWordActivity::class.java)
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