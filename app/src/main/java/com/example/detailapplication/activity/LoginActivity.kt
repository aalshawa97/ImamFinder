package com.example.detailapplication.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.content.Intent
import android.util.Log
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import android.widget.Toast
import com.example.detailapplication.R
import com.google.android.gms.tasks.Task

import com.google.android.gms.common.api.ApiException




//@repeatable
class LoginActivity : AppCompatActivity(){

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        /*
        val RC_SIGN_IN
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
        */
    }
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        //.requestIdToken("")
        .requestEmail()
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var btnSignIn: Button
        super.onCreate(savedInstanceState)
        setContentView(com.example.detailapplication.R.layout.activity_login)
        //btnSignIn = findViewById(R.id.btnSignIn)
        //viewInitializations()
        //Configure Google sign in
       // val gso:GoogleSignInOptions.Builder
    }

    fun onClick(v: View) {
        when (v.getId()) {
            com.example.detailapplication.R.id.sign_in_button -> signIn()
        }
    }

    private fun signIn() {
        // Build a GoogleSignInClient with the options specified by gso.
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        val signInIntent: Intent = mGoogleSignInClient.getSignInIntent()
        //startActivityForResult(signInIntent, RC_SIGN_IN)
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)
        //updateUI(account)
    }

    //Change UI according to user data.

    fun updateUI(account: GoogleSignInAccount?) {
        //final  val FirebaseAuth mAuth;
        //mAuth = FirebaseAuth.getInstance();
        //mAuth.signInAnonymously()
        //val mAuth
        //val user: String = mAuth.getCurrentUser().toString()

        if (account != null) {
            Toast.makeText(this, "You signed in successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "You didn't signed in", Toast.LENGTH_LONG).show()
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) = try {
        val account = completedTask.getResult(ApiException::class.java)

        // Signed in successfully, show authenticated UI.
        updateUI(account)
    } catch (e: ApiException) {
        // The ApiException status code indicates the detailed failure reason.
        // Please refer to the GoogleSignInStatusCodes class reference for more information.
        Log.w(TAG, "signInResult:failed code=" + e.statusCode)
        updateUI(null)
    }
}
