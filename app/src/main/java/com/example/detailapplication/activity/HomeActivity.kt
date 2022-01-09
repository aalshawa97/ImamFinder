package com.example.detailapplication.activity

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.detailapplication.R
import com.google.firebase.storage.StorageReference
import java.util.*
import kotlin.concurrent.schedule

class HomeActivity : AppCompatActivity() {
    lateinit var profilePicture : ImageView
    lateinit var storage : FirebaseStorage
    lateinit var storageReference: StorageReference
    
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
        setContentView(com.example.detailapplication.R.layout.activity_imam_finder_page)
        Timer("SettingUp", false).schedule(3000) {
            val myIntent = Intent(this@HomeActivity, LoginActivity::class.java)
            this@HomeActivity.startActivity(myIntent)

        }
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