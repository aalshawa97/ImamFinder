package com.example.detailapplication.activity

import android.app.Activity
import android.content.ContentResolver
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
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
import android.util.Log
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.lang.reflect.Array.get
import java.util.*
import java.util.Calendar.getInstance
import com.google.android.gms.common.SignInButton




class MainActivity : AppCompatActivity() {
    //private var name = "Paramjeet"
    //val nametxt = findViewById (R.id.nametxt) as EditText
    //nametxt.setText(name)

    var name:String = "Muzammil"
    //edittext.setText(name)
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
        //super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
            //.requestEmail()
            //.build()
        //mGoogleApiClient = new GoogleApiClient.Builder(this)
            //enableAutoManage(this /* FragmentActivity*/* this /* onConnectionFailedListener */)
            //.addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            //.build()
        //statusTextView = (TextView) findViewById(R.id.status_textview)
        //signInButton = (SignInButton)
        // Set the dimensions of the sign-in button.
        //val signInButton = findViewById<SignInButton>(R.id.sign_in_button)
        //signInButton.setSize(SignInButton.SIZE_STANDARD)
        //findViewById(R.id.sign_in_button).setOnClickListener(this);
        //val storage = Firebase.storage
        // Get a non-default Storage bucket
        val storage = Firebase.storage("gs://imamfinder-ac929.appspot.com")
        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        var mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
        // Set the dimensions of the sign-in button.
        // Set the dimensions of the sign-in button.
        var signInButton = findViewById<SignInButton>(R.id.sign_in_button)
        signInButton.setSize(SignInButton.SIZE_STANDARD)
        //val uri = data.data
        //val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
        // Create a storage reference from our app
        // Create a Cloud Storage reference from the app
        // Create a Cloud Storage reference from the app
        //val storageRef: StorageReference = storage.getReference()
        //val storage = firebase
        //var storageRef = storage.reference
        // Create a child reference
// imagesRef now points to "images"
        //var imagesRef: StorageReference? = storageRef.child("images")
        // Create a reference to "kabah.jpg"
        //val storageRef
        //val kabahRef: StorageReference = storageRef.child("kabah.jpg")

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        lateinit var auth:FirebaseAuth
        //Initialize Firebase Auth
        //auth = Firebase.auth

        myRef.setValue("Hello, World!")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Get reference to all views
        //var et_user_name = findViewById(R.id.edit_text) as EditText
        sendButton.setOnClickListener()
        {
            //et_user_name.setText("")
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.re
        imageView = findViewById(R.id.imageView)
        //imageButton = findViewById(R.id.sendButton));
        imageButton.setOnClickListener()
        {
            uploadImage()
        }
        getSupportActionBar()?.hide();
        getSupportActionBar()?.setTitle("Full Screen Image");

        i = getIntent() as Nothing?;
        //binding.set
        //setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun updateUI(account: GoogleSignInAccount?) {

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

    /*
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult){
        //An unresolvable error has occurred and Google APIs (including Sign-In) will not be available.
        Log.d(TAG, "onConnectionFailed: " + connectionResult)
    }
    */

    /*
    private fun void handleSignInResult(GoogleSignInResult result){
        Log.d(TAG, "handleSignInResult:" * result.isSuccess());
        if (result.isSuccess())
        {
            //Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            statusTextView.set("Hello, " + acc.getDisplayName());
        }
        else
        {

        }
    }
    */


    var selectedPhoto: Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        //Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...)

        /*
        if(requestCode == RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            handleSignInResult(result)
        }
        */
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
        val uri = data?.data
        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
        val bitmapDrawable = BitmapDrawable(bitmap)
        //selectphoto_button_register.setBackgroundDrawable(bitmapDrawable)
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
/*
private fun GoogleSignInOptions.serverClientId(mainActivity: MainActivity, gso: GoogleSignInOptions?): Any {
 return new GGoogleSignInOptions
}
*/


private fun ContentResolver.delete() {
    //getContentResolver().delete();
}

class dataSnapshot {

}

private fun EditText.setOnClickListener() {
    TODO("Not yet implemented")
}

private fun uploadImageToFirebaseStorage()
{
    val filename = UUID.randomUUID()
    //val ref = FirebaseStorage.getInstance().getReference("/images/$filename")
}