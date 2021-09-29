package com.example.detailapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SampleRecyclerAdapter extends RecyclerView.Adapter<SampleRecyclerAdapter.RecyclerHolder> {
    View view;
    FragmentActivity fragActivity;
    ArrayList<String> arrayList;

    public SampleRecyclerAdapter (FragmentActivity fragActivity, ArrayList<String> arrayList) {
        this.fragActivity = fragActivity;
        this.arrayList = arrayList;
    }   

    @Override
    public SampleRecyclerAdapter.RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list,parent,false);

        return new RecyclerHolder(view);
    }   

    public void dataSetChanged() {
        notifyDataSetChanged();
    }   

    @Override
    public void onBindViewHolder(SampleRecyclerAdapter.RecyclerHolder holder, int position) {
        holder.textView.setText(arrayList.get(position));   

    }   

    @Override
    public int getItemCount() {
        return arrayList.size();
    }   

    public class RecyclerHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public RecyclerHolder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.textView1);
        }
    }
}