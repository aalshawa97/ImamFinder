package com.example.detailapplication.activity

import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.view.View
import java.util.Timer
import kotlin.concurrent.schedule
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.detailapplication.*
import com.example.detailapplication.MainAdapter.*
import com.example.detailapplication.MainAdapter.Type.Pixel
import com.example.detailapplication.room.Imam
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var listAdapter: MyAdapter
    private val contactsList: ArrayList<Imam> = ArrayList()
    private lateinit var recycler: RecyclerView
    private lateinit var makeCallButton : Button
    private val newWordActivityRequestCode = 1
    private lateinit var mPhoneNumber: EditText
    private lateinit var mCode: EditText
    private lateinit var mSend: Button

    var programImages = intArrayOf(
        R.drawable.osama_alatssi_imam_finder_ic_launcher_background,
        R.drawable.abdullah_muhammad_imam_finder_ic_launcher_background,
        R.drawable.muhammad_khateeb_imam_finder_ic_launcher_background,
        R.drawable.idris_alam_imam_finder_ic_launcher_background
    )

    /*
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
        wordViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.submitList(it) }
})
    }*/

    /*
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            // Do something after 5s = 5000ms
            buttons[inew][jnew].setBackgroundColor(Color.BLACK);
        }
    }, 5000);

    val fab = findViewById<FloatingActionButton>(R.id.fab)
fab.setOnClickListener {
  val intent = Intent(this@MainActivity, NewWordActivity::class.java)
  startActivityForResult(intent, newWordActivityRequestCode)
}
    */

    /*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
                val word = Imam(it)
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }
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
        contactsList.add(Imam("Muhammad Khateeb"))
        contactsList.add(Imam("Idris Alam"))
        contactsList.add(Imam("Osama Alatssi"))
        contactsList.add(Imam("Abdullah Muhammad"))
        contactsList.add(Imam("Muhammad Muhammad"))
        contactsList.add(Imam("Mufti Muhammad Ali"))
        contactsList.add(Imam("Abdulsalam Roomal"))

        recycler = findViewById(R.id.my_recycler_view)
        var layoutManager = LinearLayoutManager(this)
        recycler?.setLayoutManager(layoutManager)
        listAdapter = MyAdapter(contactsList, this)
        recycler.setAdapter(listAdapter)

        try {
            mPhoneNumber = findViewById(R.id.phoneNumber)

            mCode = findViewById(R.id.code)
            mSend = findViewById(R.id.sendButton)


            mSend.setOnClickListener{
                Toast.makeText(this@MainActivity, "Sending...", Toast.LENGTH_SHORT)
            }
        }
        catch (e: Exception){

        }

        /*
        mSend.setOnClickListener(new View.OnClickListener()){
            @Override
            public void onClick(View v){

            }
        }
        */


        /*
        For using glide
        findViewById<RecyclerView>(R.id.list).apply {
            recycler.setAdapter(MainAdapter(applicationContext, mutableListOf(
                Type.Mask
            )))
        }
        */


        //listAdapter!!.notifyDataSetChanged()




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