package com.example.detailapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[], data2[];
    int[] images;
    Context context;
    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView myText1, myText2;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            myText1 = itemView.findViewById(R.id.imam_txt);
            myText1 = itemView.findViewById(R.id.imam_desc);
            myText1 = itemView.findViewById(R.id.myImageView);
        }
    }


    public MyAdapter(Context ct,String s1[], String s2[]){

        int sizeOfArray = 4;

        // Create an integer array
        // using reflect.Array class
        // This is done using the newInstance() method
        int[] imgs = (int[])Array
                .newInstance(int.class,
                        sizeOfArray);

        // Add elements into the array
        // This is done using the setInt() method
        Array.setInt(imgs, 0, R.drawable.muhammad_khateeb_imam_finder_ic_launcher_background);
        Array.setInt(imgs, 1, R.drawable.idris_alam_imam_finder_ic_launcher_background);
        Array.setInt(imgs, 2, R.drawable.osama_alatssi_imam_finder_ic_launcher_background);
        Array.setInt(imgs, 3, R.drawable.abdullah_muhammad_imam_finder_ic_launcher_background);

        context = ct;
        data1 = s1;
        data2 = s2;
        images = imgs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 0;

    }
}
