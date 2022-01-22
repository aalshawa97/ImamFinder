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
import paul.mr_paul.blackbot.MainActivity
import java.util.*
import kotlin.concurrent.schedule

class HomeActivity : AppCompatActivity() {
    lateinit var profilePicture : ImageView
    lateinit var storage : FirebaseStorage
    lateinit var storageReference: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.detailapplication.R.layout.activity_imam_finder_page)

        Timer("SettingUp", false).schedule(3000) {
            val myIntent = Intent(this@HomeActivity, LoginActivity::class.java)
            this@HomeActivity.startActivity(myIntent)

        }

        Timer("SettingUp", false).schedule(10000) {
            val myIntent = Intent(this@HomeActivity, ChatBotActivity::class.java)
            this@HomeActivity.startActivity(myIntent)

        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: android.content.Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}