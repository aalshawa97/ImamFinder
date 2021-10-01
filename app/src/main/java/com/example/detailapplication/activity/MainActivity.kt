package com.example.detailapplication.activity

import com.example.detailapplication.MyAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import com.example.detailapplication.Imam
import com.example.detailapplication.R
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var listAdapter: MyAdapter
    private val contactsList: ArrayList<Imam> = ArrayList()
    private lateinit var recycler: RecyclerView
    private lateinit var makeCallButton : Button

    /*
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            // Do something after 5s = 5000ms
            buttons[inew][jnew].setBackgroundColor(Color.BLACK);
        }
    }, 5000);
    */

    fun makeCall(view: View){
        Toast.makeText(this, "Phone calling", Toast.LENGTH_LONG).show()
        val intent = Intent(this, PhoneActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("5039359491")
        //startActivity(intent)

        setContentView(R.layout.recycler_view)
        makeCallButton = findViewById(R.id.button_call);
        //Load the date from the network or other resources
        //into the array list asynchronously
        contactsList.add(Imam("Muhammad Khateeb", "778899009"))
        contactsList.add(Imam("Idris Alam", "778899008"))
        contactsList.add(Imam("Osama Alatssi", "778899007"))
        contactsList.add(Imam("Abdullah Muhammad", "778899006"))
        //listAdapter!!.notifyDataSetChanged()

        recycler = findViewById(R.id.my_recycler_view)
        val layoutManager = LinearLayoutManager(this)
        recycler?.setLayoutManager(layoutManager)
        listAdapter = MyAdapter(contactsList, this)
        recycler.setAdapter(listAdapter)

        /*
        inline fun Timer.schedule(
            delay: Long,
            crossinline action: TimerTask.() -> Unit
        ): TimerTask
        */

        //

    }

    /*
    private fun MyAdapter(contactsList: ArrayList<Imam>, mainActivity: MainActivity): MyAdapter {
        MyAdapter.contactsList = contactsList
        this.mContext = mainActivity
    }
    */

}