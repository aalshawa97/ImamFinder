package com.example.detailapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.detailapplication.databinding.ActivityItemDetailBinding

class ItemDetailHostActivity : AppCompatActivity() {

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

    fun ItemListActivity(view: View)
    {

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_item_detail)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun onClick(view: View)
    {
        val text = findViewById(R.id.textView) as TextView;
        text.setText("Salemwalkom wa rahmatulhi wa baraktu imam")
        numberOfButtonClicks += 1
        //Test
        //text.setText("Button clicked..." + numberOfButtonClicks)
        uploadToFirebase()
    }

    fun onClickUploadFile(view: View)
    {
        val text = findViewById(R.id.textView) as TextView;

        if(text != null)
        {
            val text = findViewById(R.id.textView) as TextView;
            text.setText("Uploading file...")
        }

        //numberOfButtonClicks += 1
        //Test
        //text.setText("Button clicked..." + numberOfButtonClicks)
        uploadToFirebase()
    }
    fun uploadToFirebase()
    {
        //final val fileRef = reference.child(System.currentTimeMillis() + "." + get
        //fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>)
    }
}