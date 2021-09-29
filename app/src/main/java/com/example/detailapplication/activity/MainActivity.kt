package com.example.detailapplication.activity

import com.example.detailapplication.MyAdapter

import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import com.example.detailapplication.Imam
import com.example.detailapplication.R
class MainActivity : AppCompatActivity() {
    private lateinit var listAdapter: MyAdapter
    private val contactsList: ArrayList<Imam> = ArrayList()
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)


        //Load the date from the network or other resources
        //into the array list asynchronously
        contactsList.add(Imam("Muhammad Khateeb", "778899009"))
        contactsList.add(Imam("Idris Alam", "778899008"))
        contactsList.add(Imam("Osama Alatssi", "778899007"))
        contactsList.add(Imam("Abdullah Muhammad", "778899006"))
        //listAdapter!!.notifyDataSetChanged()

        recycler = findViewById(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(this)
        recycler?.setLayoutManager(layoutManager)
        listAdapter = MyAdapter(contactsList, this)
        recycler.setAdapter(listAdapter)
    }

    /*
    private fun MyAdapter(contactsList: ArrayList<Imam>, mainActivity: MainActivity): MyAdapter {
        MyAdapter.contactsList = contactsList
        this.mContext = mainActivity
    }
    */

}