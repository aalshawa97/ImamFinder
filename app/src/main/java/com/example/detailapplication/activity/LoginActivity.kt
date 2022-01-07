package com.example.detailapplication.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.content.Intent
import android.net.Uri
import java.util.Timer
import android.os.Handler
import android.os.Looper
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import com.example.detailapplication.ChatActivity
import com.example.detailapplication.MyAdapter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.example.detailapplication.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.common.SignInButton
import com.google.android.gms.tasks.Task
import kotlin.concurrent.schedule


import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.auth.User
import com.google.firebase.storage.StorageReference
import java.lang.NullPointerException
import java.security.NoSuchAlgorithmException
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

//@repeatable
class LoginActivity : AppCompatActivity(){
    //Declare and initiazlise variables
    lateinit var etPassword: EditText
    lateinit var signIn : SignInButton
    lateinit var googleApiClient: GoogleApiClient
    lateinit var textView: TextView;
    var RC_SIGN_In = 1
    lateinit var etName: EditText
    private var fromUid: String? = ""
    lateinit var tvRes: TextView
    lateinit var IVPreviewImage: ImageView
    private var imageUri: Uri? = null

    // One Button
    var BSelectImage: Button? = null
    val pickImage = 100
    // constant to compare
    // the activity result code
    var SELECT_PICTURE = 200

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            IVPreviewImage.setImageURI(imageUri)
        }
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
        .requestIdToken("509547427718-ppltqdqk6jp2njn3mj5eqjonhsfugqrf.apps.googleusercontent.com")
        .requestEmail()
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        //Initialization
        //CameraPhoto cameraPhoto = new CameraPhoto(getApplicationContext());
        super.onCreate(savedInstanceState)
        setContentView(com.example.detailapplication.R.layout.activity_login)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        try{
            val fromUser = intent.extras?.get("fromUser") as com.example.detailapplication.User
            fromUid = fromUser.uid
            var fromRooms = fromUser.rooms
            val toUser = intent.extras?.get("toUser") as User
            //val toUid = toUser.uid

        }
        catch (e : java.lang.Exception) {

        }
        /*
        try {
            val fromUser = intent.extras?.get("fromUser") as User

            fromUid = fromUser.uid
            var fromRooms = fromUser.rooms
            val toUser = intent.extras?.get("toUser") as User
            val toUid = toUser.uid
            var toRooms = toUser.rooms

            var roomId = intent.extras?.get("roomId") as String

            if (roomId == "noRoomId") {
                roomId = rootRef!!.collection("messages").document().id
                if (fromRooms != null) {
                    for ((key, _) in fromRooms) {
                        if (toRooms != null) {
                            if (toRooms.contains(key)) {
                                roomId = key
                            }
                        }
                    }
                }
            }

            val button = findViewById<Button>(R.id.button)
            val edit_text = findViewById<EditText>(R.id.edit_text)

            button.setOnClickListener {
                if (fromRooms == null) {
                    fromRooms = mutableMapOf()
                }
                fromRooms!![roomId] = true
                fromUser.rooms = fromRooms
                rootRef!!.collection("users").document(fromUid!!).set(fromUser, SetOptions.merge())
                rootRef!!.collection("contacts").document(toUid).collection("userContacts").document(fromUid!!).set(fromUser, SetOptions.merge())
                rootRef!!.collection("rooms").document(toUid).collection("userRooms").document(roomId).set(fromUser, SetOptions.merge())

                if (toRooms == null) {
                    toRooms = mutableMapOf()
                }
                toRooms!![roomId] = true
                toUser.rooms = toRooms
                rootRef!!.collection("users").document(toUid).set(toUser, SetOptions.merge())
                rootRef!!.collection("contacts").document(fromUid!!).collection("userContacts").document(toUid).set(toUser, SetOptions.merge())
                rootRef!!.collection("rooms").document(fromUid!!).collection("userRooms").document(roomId).set(toUser, SetOptions.merge())

                val messageText = edit_text.text.toString()
                val message = Message(messageText, fromUid!!)
                rootRef!!.collection("messages").document(roomId).collection("roomMessages").add(message)
                edit_text.text.clear()
            }

            val query = rootRef!!.collection("messages").document(roomId).collection("roomMessages").orderBy("sentAt", Query.Direction.ASCENDING)
            val options = FirestoreRecyclerOptions.Builder<Message>().setQuery(query, Message::class.java).build()
            adapter = MessageAdapter(options)
            recycler_view.adapter = adapter

            title = toUser.userName

            //Testing RSA
            encrypt("This is secret!")

            try {
                //cipher = Cipher.getInstance("RSA")
                val keyBytes = byteArrayOfInts(0xA1, 0x2E, 0x38, 0xD4, 0x89, 0xC3)
                val secretKey: SecretKey = SecretKeySpec(keyBytes, "AES")
                //cipher.init()
                //decipher = Cipher.getInstance("AES")
            }
            catch(e: NoSuchAlgorithmException)
            {
                e.printStackTrace()
            }

            editText = findViewById(R.id.edit_text)
            listView = findViewById(R.id.list_viw)
            rootRef = FirebaseFirestore.getInstance()
            recycler_view = findViewById(R.id.recycler_view)
        }
        catch (e : java.lang.Exception)
        {
            Log.d(TAG, "onCreate: exception thrown when getting user")
        }
        */

        /*
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });
        */

    googleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, null)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

        BSelectImage = findViewById(R.id.BSelectImage)
        IVPreviewImage = findViewById(R.id.imageView)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.editTextTextPassword)
        tvRes = findViewById(R.id.tvResult)
        title = "ImamFinder"
        BSelectImage?.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        Log.d("LoginActivity", "Hello World")
        signIn = findViewById(R.id.buttonSignIn)
        signIn.setOnClickListener{
            Toast.makeText(this, "Loading Google sign in", Toast.LENGTH_LONG)
            Log.d("LoginActivity", "signOn: " + "loading Google sign in")
            // Build a GoogleSignInClient with the options specified by gso.
            val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
            val signInIntent: Intent = mGoogleSignInClient.getSignInIntent()
            //startActivityForResult(signInIntent, RC_SIGN_IN)
            // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
            this@LoginActivity.startActivity(signInIntent)
            val account = GoogleSignIn.getLastSignedInAccount(this)
            updateUI(account)
            if (account != null) {
                Toast.makeText(applicationContext,"Hello user" + account.email, Toast.LENGTH_LONG)
            }
            //this@LoginActivity.startActivity(Intent(this@LoginActivity, ChatActivity::class.java))
        }

        //viewInitializations()
        //Configure Google sign in
       // val gso:GoogleSignInOptions.Builder
    }

    fun onClick(v: View) {
        if(etName.text.isNullOrEmpty())
        {
            Toast.makeText(this,"Could you please sign in or register? " , Toast.LENGTH_LONG).show();
        }
        if(etPassword.text.isNullOrEmpty())
        {
            Toast.makeText(this,"Could you please enter a password to sign in or register? " , Toast.LENGTH_LONG).show();
        }
        Log.d("User sign in: ", "onClick: " + etName.text + " " + etPassword)
        Toast.makeText(this,"Welcome " + etName.text, Toast.LENGTH_LONG).show();
        //setContentView(R.layout.activity_item_detail)
        //setContentView(com.example.detailapplication.R.layout.contact_list_item)

        //Intent myIntent = new Intent();
        //startActivity(this.context, myIntent, new Bundle());
        //setContentView(com.example.detailapplication.R.layout.activity_login);
        //MyAdapter.signIn.findViewById<View>(R.id.buttonSignIn)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        /*
        when (v.getId()) {
            com.example.detailapplication.R.id.sign_in_button -> signIn()
        }
        */
    }

    //this function is triggered
    fun register(view: android.view.View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun uploadPicture(){
        //StorageReference riversRef = storageRef.child("images/rivers.jpg");
    }

    // this function is triggered when
    // the Select Image Button is clicked
    fun imageChooser(view: android.view.View) {

        // create an instance of the
        // intent of the type image
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        //Pass the constant to compare it with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }


    private fun signIn() {
        // Build a GoogleSignInClient with the options specified by gso.
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        val signInIntent: Intent = mGoogleSignInClient.getSignInIntent()
        //startActivityForResult(signInIntent, RC_SIGN_IN)
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)
        //updateUI(account)
    }

    //Change UI according to user data.

    fun updateUI(account: GoogleSignInAccount?) {
        val mAuth : FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInAnonymously()
        //val mAuth
        val user: String = mAuth.getCurrentUser().toString()

        if (account != null) {
            Toast.makeText(this, "You signed in successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "You didn't sign in", Toast.LENGTH_LONG).show()
            //Toast.makeText(this, "Please sign in " + user, Toast.LENGTH_LONG).show()
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

    fun signOn(v : View) {
        Toast.makeText(this, "Loading Google sign in", Toast.LENGTH_LONG)
        Log.d("LoginActivity", "signOn: " + "loading Google sign in")
        this@LoginActivity.startActivity(Intent(this@LoginActivity, ChatActivity::class.java))
    }
}
