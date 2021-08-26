package com.example.detailapplication.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.detailapplication.databinding.ActivityStorageBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase
import java.net.URI
import java.security.AlgorithmParameterGenerator.getInstance
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.getInstance
import java.util.Currency.getInstance

class StorageActivity : Activity() {
    lateinit var binding : ActivityStorageBinding
    lateinit var ImageUri : URI
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        binding.selectImageBtn.setOnClickListener(
            selectImage()
        )
        */
        /*
        binding.uploadImageBtn.setOnClickListener{
            uploadImage()
        }
        */
    }

    fun writeNewUser(userId: String, name: String, email: String) {
        //val user = User(name, email)

        //database.child("users").child(userId).setValue(user)
    }

    //val user = Firebase.auth.currentUser
    /*user?.let {
        // Name, email address, and profile photo Url
        val name = user.displayName
        val email = user.email
        val photoUrl = user.photoUrl

        // Check if user's email is verified
        val emailVerified = user.isEmailVerified

        // The user's ID, unique to the Firebase project. Do NOT use this value to
        // authenticate with your backend server, if you have one. Use
        // FirebaseUser.getToken() instead.
        val uid = user.uid
    }*/

    private fun uploadImage(){
        //val user = Firebase.auth.currentUser
        /*
        val user
        if (user != null) {
            // User is signed in
        } else {
            // No user is signed in
        }
        */
        val progressDialog = ("Uploading File... ")

        //@IgnoreExtraProperties
        data class User(val username: String? = null, val email: String? = null) {
            // Null default values create a no-argument default constructor, which is needed
            // for deserialization from a DataSnapshot.
        }
        //progressDialog.show
        val formatter = SimpleDateFormat("yy_MM_dd_HH_mm_SS", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        lateinit var database: DatabaseReference
// ...
        database = Firebase.database.reference
        //val storageReference = FirebaseStorage.getInstance().getReference("images/$fileName")
    }

    private fun selectImage(){
        val intent = Intent()
        intent.type = "images/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK){
            //ImageUri = data?.data!!

        }
    }
}

