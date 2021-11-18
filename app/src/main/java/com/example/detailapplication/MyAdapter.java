package com.example.detailapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.detailapplication.room.Imam;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactHolder> {

    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;

    // List to store all the contact details
    private ArrayList<Imam> contactsList;
    int[] images = new int[]{ R.drawable.osama_alatssi_imam_finder_ic_launcher_background,
            R.drawable.abdullah_muhammad_imam_finder_ic_launcher_background,
            R.drawable.muhammad_khateeb_imam_finder_ic_launcher_background,
            R.drawable.idris_alam_imam_finder_ic_launcher_background }; ;
    // Counstructor for the Class
    public MyAdapter(ArrayList<Imam> contactsList, Context context) {
        this.contactsList = contactsList;
    }

    // This method creates views for the RecyclerView by inflating the layout
    // Into the viewHolders which helps to display the items in the RecyclerView
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.contact_list_item, parent, false);
        onCreateViewHolderImage(parent, viewType);
        return new ContactHolder(view);
    }

    public ImageViewHolder onCreateViewHolderImage(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.contact_list_item, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    private void initLayoutOne(ViewHolderOne holder, int pos) {
        //holder.item.setText(itemList.get(pos).getName());
    }

    private void initLayoutTwo(ViewHolderTwo holder, int pos) {
        //holder.tvLeft.setText(itemList.get(pos).getName());
        //holder.tvRight.setText(item.get(pos).getName());
    }

    // Static inner class to initialize the views of rows
    static class ViewHolderOne extends RecyclerView.ViewHolder {
        private final ImageView rowImage;
        private final int[] images;
        public TextView item;
        public ViewHolderOne(int[] images, View itemView) {
            super(itemView);
            this.images = images;
            item = (TextView) itemView.findViewById(R.id.tvRow);
            rowImage = itemView.findViewById(R.id.imageView);
            ImageView rowImage = itemView.findViewById(R.id.imageView);
            rowImage.setImageResource(this.images[0]);
        }
    }

    static class ViewHolderTwo extends RecyclerView.ViewHolder {
        public TextView tvLeft, tvRight;
        public ViewHolderTwo(View itemView) {
            super(itemView);
            tvLeft = (TextView) itemView.findViewById(R.id.row_item_left);
            tvRight = (TextView) itemView.findViewById(R.id.row_item_right);
        }
    }

    // This method is called when binding the data to the views being created in RecyclerView
    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, final int position) {
        final Imam contact = contactsList.get(position);
        //Album = holder.itemView.findViewById(R.id.myImageView);
        //holder.itemView.findViewById(R.id.myImageView)= holder.itemView.findViewById(R.id.myImageView);
        //Load the image into each row
        switch (holder.getItemViewType()) {
            case TYPE_ONE:
                //initLayoutOne((ViewHolderOne)holder, listPosition);
                break;
            case TYPE_TWO:
                //initLayoutTwo((ViewHolderTwo) holder, listPosition);
                break;
            default:
                break;
        }

        // Set the data to the views here
        holder.setContactName(contact.getWord());
        holder.setContactNumber(""+contact.getWord().length());

        // You can set click listners to indvidual items in the viewholder here
        // make sure you pass down the listner or make the Data members of the viewHolder public

    }

    public static class ImageViewHolder  extends RecyclerView.ViewHolder {
        ImageView Album;
        TextView AlbumTitle;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.myImageView);
        }
    }

    // This is your ViewHolder class that helps to populate data to the view
    public class ContactHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtNumber;

        public ContactHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtNumber = itemView.findViewById(R.id.txt_number);
        }

        public void setContactName(String name) {
            txtName.setText(name);
        }

        public void setContactNumber(String number) {
            txtNumber.setText(number);
        }
    }
}