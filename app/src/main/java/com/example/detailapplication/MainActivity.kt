package com.example.detailapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.detailapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.FirebaseDatabase
import java.io.IOException


class MainActivity : AppCompatActivity() {

    //private var cover: Any
    //private Button button
    private var imageData: ByteArray? = null
    private var selectedImage: Uri? = null
    //Remeber to use
    private val postURL: String = "https://ptsv2.com/t/54odo-1576291398/post"
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageView: ImageView
    private lateinit var sendButton : Button
    private lateinit var imageButton : Button
    //FloatingActionButton fab;
    //cover = findViewById(R.id.floatActionButton);
    //fab = findViewById(R.id.floatingActionButton);
    /*
    fab.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            ImagePicker.Companion.with(MainActivity:this)
                    .crop() //Crop image(Optional), Check Customization for more options
                    .cropOval() //Allow dimmed layer to have a circle inside
                    .compress(1024) //Final image size will be less than 1 MB(Optional)
                    .maxResultSize(width:1080, height:1080)//Final image resolutions will be less than twice
                    .start();
        }
    }
     */
    companion object
    {
        private const val IMAGE_PICK_CODE = 999
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        //ImageView cover;
        //var selectedImage: Uri? = null
        // Write a message to the database
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //button = (Button) findViewById(R.id.button
        /*
            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    openActivity2();
                }
            });

         }
        */

        /*
        public void openActivity2()
        {
            Intent intent = new Intent(this, Activity2.class);
            startActivity2(intent)
        }
         */
        //cover = findViewById(R.id.imageView2)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageView = findViewById(R.id.imageView)
        //imageButton = findViewById(R.id.sendButton));
        imageButton.setOnClickListener()
        {
            uploadImage()
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
        })
        */

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    // Create an anonymous implementation of OnClickListener
    private val mCorkyListener = View.OnClickListener {
        // do something when the button is clicked
        // Yes we will handle click here but which button clicked??? We don't know
    }

    private fun launchGallery()
    {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    private fun uploadImage()
    {
        if(selectedImage == null)
        {
            //layout_root.snackbar("Select an image first")
            return
        }
        Toast.makeText(this, "Uploading image!", Toast.LENGTH_LONG)
        imageData?: return
        /*
        val request = object : VolleyFileUpload(
            Request.Method.POST,
            postURL,
            /*Response.Listener
            {
                println("response is: $it")
            },*/
            Response.ErrorListener {
                println("error is: $it")
            }
        )
        */
        /*override fun getByteData():MutableMap<String, FileDataPart>
        {
            var params = HashMap<String, FileDataPart>()
            params["imageFile"] = FileDataPart("image", imageData!!, "jpeg")
            return params
        }
        */
        //Volley.newRequestQueue(this).add(request)
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
            val uri = data?.data
            if(uri != null)
            {
                imageView.setImageURI(uri)
                createImageData(uri)
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
}