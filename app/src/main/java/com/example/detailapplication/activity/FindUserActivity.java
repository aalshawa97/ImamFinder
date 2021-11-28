package com.example.detailapplication.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.detailapplication.activity.ContactsActivity;

import com.example.detailapplication.R;

public class FindUserActivity extends AppCompatActivity {
    private RecyclerView mUserList;
    private RecyclerView.Adapter mUserListAdapter;
    private RecyclerView.LayoutManager mUserListLayoutManager;
    private Object ContactsActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Open an activity to show contacts
        transaction.add(R.id.container, (Fragment) ContactsActivity,"Contacts Activity");
        transaction.addToBackStack(null);
        transaction.commit();
        mUserList = findViewById(R.id.userList);
        //Open fragment from activity

        //mUserList = setNestedScrollingEnabled(false);
        mUserList.setHasFixedSize(false);
        mUserListLayoutManager = new LinearLayoutManager(getApplicationContext());
        mUserList.setLayoutManager(mUserListLayoutManager);
    }
}
