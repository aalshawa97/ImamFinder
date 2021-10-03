package com.example.detailapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import java.util.Timer
import kotlin.concurrent.schedule

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.detailapplication.R.layout.activity_imam_finder_page)
        Timer("SettingUp", false).schedule(3000) {
            val myIntent = Intent(this@HomeActivity, LoginActivity::class.java)
            this@HomeActivity.startActivity(myIntent)
        }
    }
}