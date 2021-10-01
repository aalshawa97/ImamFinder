package com.example.detailapplication.activity

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.detailapplication.R
import com.example.detailapplication.SampleRecyclerAdapter
import com.example.detailapplication.databinding.ActivityItemDetailBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.fragment_item_list.*


class ItemDetailHostActivity : AppCompatActivity() {
    lateinit var imageView : ImageView
    lateinit var button: Button
    val pickImage = 100
    var imageUri: Uri? = null
    lateinit var etName: EditText   //declartion
    lateinit var tvRes: TextView
    lateinit var recyclerView : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var myAdapter: SampleRecyclerAdapter
    var s1 = arrayOf("")
    var s2 = arrayOf("")
    var names : ArrayList<String> = arrayListOf("Muhammad Khateeb", "Idris Alam", "Osama Alatssi", "Abdullah Mohammad")
    val images : kotlin.Array<Int> = arrayOf(
        R.drawable.muhammad_khateeb_imam_finder_ic_launcher_background,
        R.drawable.idris_alam_imam_finder_ic_launcher_background,
        R.drawable.osama_alatssi_imam_finder_ic_launcher_background,
        R.drawable.abdullah_muhammad_imam_finder_ic_launcher_background
    )
    //printNumbers(*numbers.toIntArray())
    //var images= (R.drawable.muhammad_khateeb_imam_finder_ic_launcher_background, R.drawable.idris_alam_imam_finder_ic_launcher_background, R.drawable.osama_alatssi_imam_finder_ic_launcher_background, R.drawable.abdullah_muhammad_imam_finder_ic_launcher_background)
    //var arr = arrayOfNulls<Int>(10)

    private lateinit var appBarConfiguration: AppBarConfiguration
    var numberOfButtonClicks = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Initialization
        tvRes = findViewById(R.id.tvResult)
        etName = findViewById(R.id.etName)
        s1 = resources.getStringArray(R.array.imams)
        s2 = resources.getStringArray(R.array.description)
        recyclerView = item_list
        myAdapter = SampleRecyclerAdapter(this, names)
        recyclerView.adapter = (myAdapter)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
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

    fun onLogin(view: View) {
        var name = etName.text.toString()
        Toast.makeText(this@ItemDetailHostActivity, name, Toast.LENGTH_LONG).show()
        tvRes.setText("Welcome " + name)
        setContentView(R.layout.activity_login)
        //Invoke the login using an implicit intent
        val loginIntent = Intent(Intent.ACTION_PICK)
        //Toast.makeText(this,"Logging in", Toast.LENGTH_LONG).show()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            //.requestIdToken("")
            .requestEmail()
              .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        val signInIntent: Intent = mGoogleSignInClient.getSignInIntent()
        //startActivityForResult(signInIntent, RC_SIGN_IN)
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)
        //updateUI(account)
        //val layoutPhone.visibility = View.VISIBLE
    }

    fun firebaseAuthWithGoogle(idToken: String)
    {
        //AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null)
    }


    fun onClick(view: View)
    {
        var name = etName.text.toString()
        Toast.makeText(this@ItemDetailHostActivity, name, Toast.LENGTH_LONG).show()
        tvRes.setText("Welcome " + name)
        Toast.makeText(this,"Welcome " + name, Toast.LENGTH_LONG).show();
        
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
        uploadToFirebase()
        //Invoke the image gallery using an implicit intent

        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        val text = findViewById(R.id.textView) as TextView;

        //Where do we want to find the data?

        val pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        val pictureDirectoryPath = pictureDirectory.getPath()

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

        //imageView = findViewById(R.id.imageView2)

        button = findViewById(R.id.fab)
        button.setOnClickListener{
            val gallary = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallary, pickImage)
        }

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
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Hiring pool")

        myRef.setValue("Hire the imam: " + "Nouman Khan!")
        readFromDataBase()
        //database.child("users").child(userId).setValue(user)


        //val reference
        //val fileRef = reference.child(System.currentTimeMillis() + "." + get
        //fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>)
    }

    /*
    val childEventListener = object : ChildEventListener {
        override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
            Log.d(TAG, "onChildAdded:" + dataSnapshot.key!!)

            // A new comment has been added, add it to the displayed list
            val comment = dataSnapshot.getValue<Comment>()

            // ...
        }

        override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
            Log.d(TAG, "onChildChanged: ${dataSnapshot.key}")

            // A comment has changed, use the key to determine if we are displaying this
            // comment and if so displayed the changed comment.
            val newComment = dataSnapshot.getValue<Comment>()
            val commentKey = dataSnapshot.key

            // ...
        }

        override fun onChildRemoved(dataSnapshot: DataSnapshot) {
            Log.d(TAG, "onChildRemoved:" + dataSnapshot.key!!)

            // A comment has changed, use the key to determine if we are displaying this
            // comment and if so remove it.
            val commentKey = dataSnapshot.key

            // ...
        }

        override fun onChildMoved(dataSnapshot: DataSnapshot, previousChildName: String?) {
            Log.d(TAG, "onChildMoved:" + dataSnapshot.key!!)

            // A comment has changed position, use the key to determine if we are
            // displaying this comment and if so move it.
            val movedComment = dataSnapshot.getValue<Comment>()
            val commentKey = dataSnapshot.key

            // ...
        }

        fun onCancelled(databaseError: DatabaseError) {
            Log.w(TAG, "postComments:onCancelled", databaseError.toException())
            Toast.makeText(this, "Failed to load comments.",
                Toast.LENGTH_SHORT).show()
        }
    }
    databaseReference.addChildEventListener(childEventListener)
    */
    fun readFromDataBase()
    {
        Toast.makeText(this,"Downloading", Toast.LENGTH_LONG).show()
        val database = FirebaseDatabase.getInstance().getReference("Hiring pool")
        database.child("Hiring pool").child("Abdullah Mutaz")
        /*if(it.exists()){

        }
        */
        //myRef.database.("Hire the imam: " + "Nouman Khan!")
        //readFromDataBase()
        //import { getStorage, ref } from "firebase/storage";

        // Get a reference to the storage service, which is used to create references in your storage bucket
        //const storage = getStorage();

        // Create a storage reference from our storage service
        //const storageRef = ref(storage);
        // Read from the database
        /*
        database.addValueEventListener(object : ValueEventListener {
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
    val menuListener = object : ValueEventListener {
        override fun onCancelled(databaseError: DatabaseError) {
            // handle error
        }
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            //user = dataSnapshot.getValue(User::class.java)
            //textView.text = user?.name
        }
    }
}