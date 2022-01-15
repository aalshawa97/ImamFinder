package com.example.detailapplication.activity

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.detailapplication.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.storage.StorageReference
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule
import kotlin.math.log

class HomeActivity : AppCompatActivity() {
    lateinit var profilePicture : ImageView
    private lateinit var chatsRV : RecyclerView;
    private lateinit var userMsgEdt : EditText;
    lateinit var storage : FirebaseStorage
    private lateinit var sendMsgFAB : FloatingActionButton;
    lateinit var storageReference: StorageReference
    private final var BOT_KEY : String  = "bot"
    private final var USER_KEY : String  = "user"
    private lateinit var chatsModelArrayList : ArrayList<ChatsModel>
    private lateinit var chatRVAdapter : ChatRVAdapter;
    private lateinit var mRequestQueue : RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MainAdapter(context, mutableListOf(
                Mask, NinePatchMask, RoundedCorners, CropTop, CropCenter, CropBottom, CropSquare, CropCircle,
                CropCircleWithBorder, Grayscale, BlurLight, BlurDeep, Toon, Sepia, Contrast, Invert,
                Pixel, Sketch, Swirl, Brightness, Kuawahara, Vignette
            ))
        }
        */
        setContentView(R.layout.chat)
        chatsRV = findViewById(R.id.idRVChats)
        userMsgEdt = findViewById(R.id.idEdtMessage);
        sendMsgFAB = findViewById(R.id.idFABSend);
        chatsModelArrayList = ArrayList()
        chatRVAdapter = ChatRVAdapter(chatsModelArrayList, this)
        var manager : LinearLayoutManager = LinearLayoutManager(this)
        chatsRV.layoutManager = manager
        chatsRV.adapter = chatRVAdapter

        // below line is to initialize our request queue.
        mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.getCache().clear();

        sendMsgFAB.setOnClickListener(View.OnClickListener {
            if (userMsgEdt.getText().toString().isEmpty()) {
                // if the edit text is empty display a toast message.
                Toast.makeText(this, "Please enter your message..", Toast.LENGTH_SHORT).show();
                //return;
            }

            // calling a method to send message
            // to our bot to get response.
            getResponse(userMsgEdt.getText().toString());

            // below line we are setting text in our edit text as empty
            userMsgEdt.setText("");
        })
        Timer("SettingUp", false).schedule(3000) {
            val myIntent = Intent(this@HomeActivity, LoginActivity::class.java)
            this@HomeActivity.startActivity(myIntent)
            if(userMsgEdt.text.toString().isEmpty()){
                Looper.prepare()
               Toast.makeText(applicationContext, "Please enter your message", Toast.LENGTH_SHORT).show()
            }
            getResponse(userMsgEdt.text.toString())
            userMsgEdt.setText("")
        }
        // on below line we are initialing our adapter class and passing our array list to it.
        // on below line we are initialing our adapter class and passing our array list to it.
        chatRVAdapter = ChatRVAdapter(chatsModelArrayList, this)

        // below line we are creating a variable for our linear layout manager.

        // below line we are creating a variable for our linear layout manager.
        val linearLayoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // below line is to set layout
        // manager to our recycler view.

        // below line is to set layout
        // manager to our recycler view.
        chatsRV.layoutManager = linearLayoutManager

        // below line we are setting
        // adapter to our recycler view.

        // below line we are setting
        // adapter to our recycler view.
        chatsRV.adapter = chatRVAdapter
    }

    private fun getResponse(message : String){
        // creating a variable for our request queue.
        // creating a variable for our request queue.
        val queue = Volley.newRequestQueue(this)

        chatsModelArrayList.add( ChatsModel(message, USER_KEY))
        try{
            chatRVAdapter.notifyDataSetChanged()
        }
        catch (e : Exception)
        {
            Log.d(TAG, "getResponse: " + e.toString())
        }
        var url : String = "http://api.brainshop.ai/get?bid=162882&key=t3JF55qSHHY5Ga5v&uid=[uid]&msg="+message
        var BASE_URL : String = "http://api.brainshop.ai/"
        var retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create())
            .build()
        var retrofitApi : RetrofitAPI = retrofit.create()
        var call : Call<MsgModel> = retrofitApi.getMessage(url)
        call.enqueue(object : Callback<MsgModel> {
            override fun onFailure(call: Call<MsgModel>?, t: Throwable?) {
                Log.v("retrofit", "call failed")
                chatsModelArrayList.add(ChatsModel("Please revert your question", BOT_KEY))
                chatRVAdapter.notifyDataSetChanged()
            }

            override fun onResponse(call: Call<MsgModel>?, response: Response<MsgModel>?) {
                if (response != null) {
                    if(response.isSuccessful()) {
                        var model : MsgModel? = response.body()
                        if (model != null) {
                            chatsModelArrayList.add(ChatsModel(model.message, BOT_KEY))
                            chatRVAdapter.notifyDataSetChanged()
                        }
                    }
                }
            }

        })
        // at last adding json object
        // request to our queue.
       //queue.add(jsonObjectRequest);
    }

    fun uploadPicture(){
        //final String randomKey = UUID.randomUUID().toString();
        var randomKey : String
        randomKey = UUID.randomUUID().toString()
        var riversRef : StorageReference
    }

    fun choosePicture(){
        val intent = Intent(this, PhotoActivity::class.java)
        intent.setType("image/*")
        uploadPicture()
        intent.setAction(Intent.ACTION_GET_CONTENT)
        //startActivityForResult(intent)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: android.content.Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        //super.onActivityResult(requestCode, resultCode, data)
        //if(requestCode == 1 )
    }
/*
    FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
        if (!task.isSuccessful) {
            Log.w(TAG, "Fetching FCM registration token failed", task.exception)
            return@OnCompleteListener
        }

        // Get new FCM registration token
        val token = task.result

        // Log and toast
        val msg = getString(R.string.msg_token_fmt, token)
        Log.d(TAG, msg)
        Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
    })*/
}