package com.example.detailapplication.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.detailapplication.R
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.concurrent.schedule

class RegisterActivity : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth? = null
    private var authStateListener: FirebaseAuth.AuthStateListener? = null
    private var googleApiClient: GoogleApiClient? = null
    private var rootRef: FirebaseFirestore? = null
    private lateinit var previewImage: ImageView
    private var imageUri: Uri? = null

    // One Button
    var bSelectImage: Button? = null
    var bSkip: Button? = null
    var bChat: Button? = null
    var toolBar: Toolbar? = null
    val pickImage = 100
    //Constant to compare the activity result code
    var selectPicture = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(applicationContext)
        setContentView(R.layout.activity_register)
        //When user taps on a new activity we need to go to it!
        //layoutManager
        val options = FirebaseOptions.Builder()
            .setApplicationId("1:123140511070:android:a5c84837bb6de83502ebcf") // Required for Analytics.
            .setProjectId("hospitallocator-be5cd") // Required for Firebase Installations.
            .setApiKey("AIzaSyDhp9velxKCu4zR7j8iQJTuJvGY9pjnPoU") // Required for Auth.
            .build()
        rootRef = FirebaseFirestore.getInstance()
        //google_sign_in_button.setOnClickListener { signIn() }

        firebaseAuth = FirebaseAuth.getInstance()
        authStateListener = FirebaseAuth.AuthStateListener { auth ->
            val firebaseUser = auth.currentUser
            if(auth.currentUser != null)
            {
                Toast.makeText(this, auth.currentUser?.displayName + " is signed on!", Toast.LENGTH_LONG).show()

            }

            //val idToken: GoogleIdToken = verifier.verify(idTokenString)

            if (firebaseUser != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.server_client_id))
            .requestEmail()
            .build()


        googleApiClient = GoogleApiClient.Builder(applicationContext)
            .enableAutoManage(this) { Toast.makeText(
                this,
                "You got a GoogleApiClient Error!",
                Toast.LENGTH_SHORT
            ).show() }
            .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
            .build()
        /*

         */

        //myIntent = Intent(this@LoginActivity, MainActivityJ::class.java)
        //this@LoginActivity.startActivity(myIntent)

        //Open chat
        /*
        bChat = findViewById(R.id.buttonChat)
        bChat?.setOnClickListener {
            Log.d("LoginActivity", "openChat: ")
            var myIntent = Intent(this@LoginActivity, RSAactivity::class.java)
            //this@LoginActivity.startActivity(myIntent)

            Log.d("Opening messenger", "openChat: ")
            Timer("SettingUp", false).schedule(20000) {
                Intent(this@LoginActivity, ChatActivity::class.java)
                //this@LoginActivity.startActivity(myIntent)
            }
            this@LoginActivity.startActivity(myIntent)
        }
        */
    }

    fun onClick(view: android.view.View)
    {
        Toast.makeText(this, "Registering user", Toast.LENGTH_LONG)
        Log.d("Registering user", "onClick: ")
    }
}