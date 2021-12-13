package com.example.detailapplication.activity

import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.view.View
import java.util.Timer
import kotlin.concurrent.schedule
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import com.example.detailapplication.*
import com.example.detailapplication.MainAdapter.*
import com.example.detailapplication.MainAdapter.Type.Pixel
import com.example.detailapplication.room.Imam
import java.io.File
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var listAdapter: MyAdapter
    private val contactsList: ArrayList<Imam> = ArrayList()
    private lateinit var recycler: RecyclerView
    private lateinit var makeCallButton : Button
    private val newWordActivityRequestCode = 1
    private lateinit var mPhoneNumber: EditText
    private lateinit var mCode: EditText
    private lateinit var mSend: Button
    private lateinit var profilePicture : ImageView

    var programImages = intArrayOf(
        R.drawable.osama_alatssi_imam_finder_ic_launcher_background,
        R.drawable.abdullah_muhammad_imam_finder_ic_launcher_background,
        R.drawable.muhammad_khateeb_imam_finder_ic_launcher_background,
        R.drawable.idris_alam_imam_finder_ic_launcher_background
    )

    /*
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
        wordViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.submitList(it) }
})
    }*/

    /*
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            // Do something after 5s = 5000ms
            buttons[inew][jnew].setBackgroundColor(Color.BLACK);
        }
    }, 5000);

    val fab = findViewById<FloatingActionButton>(R.id.fab)
fab.setOnClickListener {
  val intent = Intent(this@MainActivity, NewWordActivity::class.java)
  startActivityForResult(intent, newWordActivityRequestCode)
}
    */

    /*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
                val word = Imam(it)
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }
    */

    fun makeCall(view: View){
        Toast.makeText(this, "Phone calling", Toast.LENGTH_LONG).show()
        val intent = Intent(this, PhoneActivity::class.java)
        startActivity(intent)
    }

    /*
    private fun saveFiletoDrive(file: File, mime: String) {
        Drive.DriveApi.newDriveContents(mDriveClient).setResultCallback(
            object : ResultCallback<DriveContentsResult?>() {
                fun onResult(result: DriveContentsResult) {
                    if (!result.getStatus().isSuccess()) {
                        Log.i(TAG, "Failed to create new contents.")
                        return
                    }
                    Log.i(TAG, "Connection successful, creating new contents...")
                    var outputStream: OutputStream? = result.getDriveContents()
                        .getOutputStream()
                    var fis: FileInputStream?
                    try {
                        fis = FileInputStream(file.path)
                        val baos = ByteArrayOutputStream()
                        val buf = ByteArray(1024)
                        var n: Int
                        while (-1 != fis.read(buf).also { n = it }) baos.write(buf, 0, n)
                        val photoBytes: ByteArray = baos.toByteArray()
                        outputStream.write(photoBytes)
                        outputStream.close()
                        outputStream = null
                        fis.close()
                        fis = null
                    } catch (e: FileNotFoundException) {
                        Log.w(TAG, "FileNotFoundException: " + e.getMessage())
                    } catch (e1: IOException) {
                        Log.w(TAG, "Unable to write file contents." + e1.getMessage())
                    }
                    val title = file.name
                    val metadataChangeSet: MetadataChangeSet = Builder()
                        .setMimeType(mime).setTitle(title).build()
                    if (mime == MIME_PHOTO) {
                        if (VERBOSE) Log.i(
                            TAG, "Creating new photo on Drive (" + title
                                    + ")"
                        )
                        Drive.DriveApi.getFolder(
                            mDriveClient,
                            mPicFolderDriveId
                        ).createFile(
                            mDriveClient,
                            metadataChangeSet,
                            result.getDriveContents()
                        )
                    } else if (mime == MIME_VIDEO) {
                        Log.i(
                            TAG, "Creating new video on Drive (" + title
                                    + ")"
                        )
                        Drive.DriveApi.getFolder(
                            mDriveClient,
                            mVidFolderDriveId
                        ).createFile(
                            mDriveClient,
                            metadataChangeSet,
                            result.getDriveContents()
                        )
                    }
                    if (file.delete()) {
                        if (VERBOSE) Log.d(TAG, "Deleted " + file.name + " from sdcard")
                    } else {
                        Log.w(TAG, "Failed to delete " + file.name + " from sdcard")
                    }
                }
            })
    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //var cover = findViewById(R.id.coverImg);
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("5039359491")
        //startActivity(intent)

        setContentView(R.layout.recycler_view)
        makeCallButton = findViewById(R.id.button_call);
        //Load the date from the network or other resources
        //into the array list asynchronously
        contactsList.add(Imam("Muhammad Multe Khateeb", "5039359491", "/drawable_200px_ismail_ibn_musa_menks_talk_at_kerala_state_business_excellence_awards_2015"))
        /*
        contactsList.add(Imam("Muhammad Multe"))
        contactsList.add(Imam("Idris Alam"))
        contactsList.add(Imam("Osama Alatssi"))
        contactsList.add(Imam("Abdullah Muhammad"))
        contactsList.add(Imam("Muhammad Muhammad"))
        contactsList.add(Imam("Mufti Muhammad Ali"))
        contactsList.add(Imam("Abdulsalam Roomal"))
        */

        recycler = findViewById(R.id.my_recycler_view)
        var layoutManager = LinearLayoutManager(this)
        recycler?.setLayoutManager(layoutManager)
        listAdapter = MyAdapter(contactsList, this)
        recycler.setAdapter(listAdapter)


        /*
        new Thread() {
            @Override
            public void run() {
                // write content to DriveContents
                OutputStream outputStream = driveContents.getOutputStream();
                // Write the bitmap data from it.
                MetadataChangeSet metadataChangeSet = new MetadataChangeSet.Builder()
                    .setMimeType("image/jpeg").setTitle(title)
                    .build();
                Bitmap image = BitmapFactory.decodeFile(location));
                ByteArrayOutputStream bitmapStream = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.JPEG, 80, bitmapStream);
                try {
                    outputStream.write(bitmapStream.toByteArray());
                } catch (IOException e1) {
                    Log.i("E", "Unable to write file contents.");
                }
                image.recycle();
                outputStream = null;
                String title = "noisy";

                Log.i("E", "Creating new pic on Drive (" + title + ")");
                Drive.DriveApi.getFolder(mGoogleApiClient,driveId)
                    .createFile(mGoogleApiClient, metadataChangeSet, driveContents)
                    .setResultCallback(fileCallback);
            }
        }.start();
        */
        try {
            mPhoneNumber = findViewById(R.id.phoneNumber)

            mCode = findViewById(R.id.code)
            mSend = findViewById(R.id.sendButton)


            mSend.setOnClickListener{
                Toast.makeText(this@MainActivity, "Sending...", Toast.LENGTH_SHORT)
            }
        }
        catch (e: Exception){

        }

        /*
        mSend.setOnClickListener(new View.OnClickListener()){
            @Override
            public void onClick(View v){

            }
        }
        */


        /*
        For using glide
        findViewById<RecyclerView>(R.id.list).apply {
            recycler.setAdapter(MainAdapter(applicationContext, mutableListOf(
                Type.Mask
            )))
        }
        */


        //listAdapter!!.notifyDataSetChanged()




        /*
        inline fun Timer.schedule(
            delay: Long,
            crossinline action: TimerTask.() -> Unit
        ): TimerTask
        */

        //

    }

    /*
    private fun MyAdapter(contactsList: ArrayList<Imam>, mainActivity: MainActivity): MyAdapter {
        MyAdapter.contactsList = contactsList
        this.mContext = mainActivity
    }
    */

}