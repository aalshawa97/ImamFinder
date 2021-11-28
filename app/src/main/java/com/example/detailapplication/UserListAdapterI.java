package com.example.detailapplication;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

public interface UserListAdapterI<UserObject> {
    @NonNull
    UserListAdapter.UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @NonNull
    void onBindViewHolder(@NonNull UserListAdapter.UserListViewHolder holder, int position);

    int getItemCount();
}
