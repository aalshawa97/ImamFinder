package com.example.detailapplication

import android.content.Intent
import android.graphics.PointF.length
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.detailapplication.databinding.ActivityItemDetailBinding
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot

import com.google.firebase.database.ValueEventListener







class ItemDetailHostActivity : AppCompatActivity() {
    lateinit var imageView : ImageView
    lateinit var button: Button
    val pickImage = 100
    var imageUri: Uri? = null
    private lateinit var appBarConfiguration: AppBarConfiguration
    var numberOfButtonClicks = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_item_detail) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_item_detail)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private companion object {
        var sendIntent = 1
    }

    fun onClick(view: View)
    {
        val text = findViewById(R.id.textView) as TextView;
        val shareText = "Hire me!"
        //val settings = Intent(this, SettingsActivity::class.java)

        val sendIntent = Intent()
        sendIntent.setAction(Intent.ACTION_SEND)
        //sendIntent.type("text/plain")
        text.setText("Salemwalkom wa rahmatulhi wa baraktu imam, how are you? I am interested in hiring you!")
        numberOfButtonClicks += 1
        Toast.makeText(this,"Firebase connection success", Toast.LENGTH_LONG).show()
        uploadToFirebase()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun onClickUploadFile(view: View)
    {
        //Invoke the image gallery using an implicit intent
        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        val text = findViewById(R.id.textView) as TextView;

        //Where do we want to find the data?
        val pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        val pictureDirectoryPath = pictureDirectory.getPath();
        //Finally, get a URI representation
        val data = Uri.parse(pictureDirectoryPath)
        //Set the data and type. Get all image types
        photoPickerIntent.setDataAndType(data, "image/*")
        //We will invoke this activity, and get something back from it.
        val IMAGE_GALLERY_REQUEST = 0
        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST)
        if(text != null)
        {
            val text = findViewById(R.id.textView) as TextView;
            text.setText("Uploading file...")
        }

        imageView = findViewById(R.id.imageView2)

        button = findViewById(R.id.fab)
        button.setOnClickListener{
            val gallary = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallary, pickImage)
        }

        //numberOfButtonClicks += 1
        //Test
        text.setText("Button clicked..." + numberOfButtonClicks)
        uploadToFirebase()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && requestCode == pickImage)
        {
            imageUri = data?.data
            imageView.setImageURI(imageUri)
        }

    }
    fun uploadToFirebase()
    {
        Toast.makeText(this,"Uploading", Toast.LENGTH_LONG).show()
        // Write a message to the database
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hire the imam!")
        //val reference
        //val fileRef = reference.child(System.currentTimeMillis() + "." + get
        //fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>)
    }
    
    fun readFromDataBase()
    {
        // Read from the database
        // Read from the database
        /*
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

         */
    }
}