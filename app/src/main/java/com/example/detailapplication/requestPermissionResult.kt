//Abdullah Mutaz Alshawa
//8/27/2021
//Request permissions for result
package com.example.detailapplication

import android.content.pm.PackageManager
import android.widget.Toast

class requestPermissionResult
{
     fun onRequestPermissionsResult(
         requestCode: Int,
         permissions: Array<out String>,
         grantResults: IntArray
     )
    {
        when(requestCode){
            /*
            PERMISSION_CODE -> {
                if(grantResults.isNotEmpty() && grantResults[0] ==PackageManager.PERMISSION_GRANTED)
                {
                    chooseImageGallery()
                }
                else
                {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }

            }
             */
        }
    }
}