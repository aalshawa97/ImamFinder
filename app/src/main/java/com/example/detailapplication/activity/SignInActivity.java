package com.example.detailapplication.activity;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.security.NoSuchAlgorithmException;

public class SignInActivity extends AppCompatActivity {
    private static final String PUBLIC_PATH = " ";
    private static int SIGN_IN_REQUEST_CODE = 1;
    //private FirebaseListAdapter<ChatMessage> adapter;
    private final int interval = 1000; // 1 Second
    RelativeLayout activity_main;
    FloatingActionButton fab;

    public SignInActivity() throws NoSuchAlgorithmException {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        if(item.getItemId() == R.id.menu_sign_out )
        {

            AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Snackbar.make(findViewById(android.R.id.content),"You have been signed out.",Snackbar.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
        */

        return true;
    }
}
