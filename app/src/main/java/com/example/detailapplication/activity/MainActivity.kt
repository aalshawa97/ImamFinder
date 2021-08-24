package com.example.detailapplication.activity

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.detailapplication.R
import com.example.detailapplication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.io.File
import java.io.IOException
import android.os.Environment
import android.provider.MediaStore

class MainActivity : AppCompatActivity() {
    val List = listOf("image1", "image2")
    private var imageData: ByteArray? = null
    private var selectedImage: Uri? = null
    //Remember to use
    private val postURL: String = "https://ptsv2.com/t/54odo-1576291398/post"
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageView: ImageView
    //private lateinit var imageView: ImageView2
    private lateinit var sendButton : Button
    private lateinit var imageButton : Button

    companion object
    {
        private const val IMAGE_PICK_CODE = 999
        var i = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        lateinit var auth:FirebaseAuth
        //Initialize Firebase Auth
        //auth = Firebase.auth

        myRef.setValue("Hello, World!")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Get reference to all views
        var et_user_name = findViewById(R.id.edit_text) as EditText
        sendButton.setOnClickListener()
        {
            et_user_name.setText("")
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageView = findViewById(R.id.imageView)
        //imageButton = findViewById(R.id.sendButton));
        imageButton.setOnClickListener()
        {
            uploadImage()
        }
        getSupportActionBar()?.hide();
        getSupportActionBar()?.setTitle("Full Screen Image");

        i = getIntent() as Nothing?;

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    public fun onDataChange()
    {
        val list = arrayListOf<Int>()
        list.addAll(listOf(1))
        Toast.makeText(this, "Hi", Toast.LENGTH_LONG)
        list.clear()

    }

    // Create an anonymous implementation of OnClickListener
    private val mCorkyListener = View.OnClickListener {
        // do something when the button is clicked
        // Yes we will handle click here but which button clicked??? We don't know
    }

    private fun installApk()
    {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(
            Uri.fromFile(
                File(
                    Environment.getExternalStorageDirectory().toString() + "/download/" + "app.apk"
                )
            ), "application/vnd.android.package-archive"
        )
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun openScreenshot(imageFile: String) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        startActivity(intent)
    }

    private fun deletePhoto()
    {
        getContentResolver().delete();
    }

    private fun launchGallery()
    {
        val file = "C:\\Users\\15039\\Pictures\\Ismail_ibn_Musa_Menks_talk_at_Kerala_State_Business_Excellence_Awards_2015.jpg"
        openScreenshot(file)
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        //intent.setDataAndType(https://pbs.twimg.com/profile_images/1102171650982928385/JR6X6tOB_400x400.jpg, ".jpg")
        //onActivityResult(intent, IMAGE_PICK_CODE)
    }

    fun openSomeActivityForResult()
    {

    }

    private fun uploadImage()
    {
        sendBroadcast(
            Intent(
                Intent.ACTION_MEDIA_MOUNTED,
                Uri.parse("file://" + Environment.getExternalStorageDirectory())
            )
        )
        if(selectedImage == null)
        {
            return
        }
        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(
            takePicture,
            0
        )
        imageData?: return

    }

    @Throws(IOException::class)
    private fun createImageData(uri: Uri)
    {
        val inputStream = contentResolver.openInputStream(uri)
        inputStream?.buffered()?.use{
            imageData = it.readBytes()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE)
        {
            Toast.makeText(this,"Setting image", Toast.LENGTH_LONG)
            val uri = data?.data
            if(uri != null)
            {
                imageView.setImageURI(null)
                imageView.setImageURI(uri)
                //imageView2.setImageURI(uri)
                createImageData(uri)
                imageView.adjustViewBounds
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSupportNavigateUp(): Boolean
    {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    suspend fun loginUser(email: String, password: String)
    {
        try
        {
            //firebase.com
        }
        catch (e: Exception)
        {

        }
    }
}

private fun ContentResolver.delete() {
    //getContentResolver().delete();
}

class dataSnapshot {

}

private fun EditText.setOnClickListener() {
    TODO("Not yet implemented")
}
