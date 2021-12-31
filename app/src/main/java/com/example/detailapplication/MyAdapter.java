package com.example.detailapplication;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.detailapplication.room.Imam;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONException;
import org.json.JSONObject;
//Read from json imports

import org.json.simple.parser.*;
// import org.json.simple.*;
//import org.json.simple.parser.ParseException;


import java.io.File;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactHolder> implements GoogleApiClient.OnConnectionFailedListener {

    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private Context context;
    private static final int RC_SIGN_In = 1;
    private static final int RC_SIGN_IN = 1;
    private GoogleApiClient googleApiClient;
    private static SignInButton signIn;
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
        //setView
        try
        {
            signIn.findViewById(R.id.buttonSignIn);
        }
        catch (Exception e)
        {

        }
        return new ContactHolder(view);
    }


    public ImageViewHolder onCreateViewHolderImage(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.contact_list_item, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        /*
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                context = context.getApplicationContext();
                context.startActivity(intent);
                //startActivityForResult(this,intent,RC_SIGN_IN,gso);
            }
        });
        */


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

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

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
        //holder.itemView.findViewById(R.id.myImageView) = holder.itemView.findViewById(R.drawable.idris_alam_imam_finder_ic_launcher_background);
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
        holder.setContactNumber(contact.getPhone());
        holder.setContactPhoto(contact.getImg_uri());

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
    public static class ContactHolder extends RecyclerView.ViewHolder {

        private TextView txtName = null;
        private TextView txtNumber= null;
        private ImageView profilePicture = null;

        public ContactHolder(View itemView) {
            super(itemView);
            // Create a storage reference from our app
            //Storage storage = null;
            // Create a storage reference from our app
            //
            // StorageReference storageRef = (StorageReference) storage.getReference();
            FirebaseStorage storage = FirebaseStorage.getInstance();
           // StorageReference storageRef = storage.getReferenceFromUrl("Url to storage");
            StorageReference storageRef = storage.getReference();
            Uri uri = Uri.parse("C:\\Users\\15039\\AndroidStudioProjects\\ImamFinder\\app\\src\\main\\res\\drawable\\mask_starfish.png");
            //new ViewHolderOne(getResources);
            // storageRef.putFile(uri);
            Toast.makeText(itemView.getContext(), "URI: " + uri.toString(), Toast.LENGTH_LONG);

            /*
            try {

                InputStream input = context.getContentResolver().openInputStream(uri);
                if (input == null) {
                    return null;
                }
                return BitmapFactory.decodeStream(input);
            }
            catch (FileNotFoundException e)
            {

            }
            */
            // Create a child reference
            // imagesRef now points to "images"
            //StorageReference imagesRef = Space.getRoot();
            profilePicture = itemView.findViewById(R.id.GfG_logo);
            setContactPhoto(uri.toString());
            //Store the data of the imam from JSON
            JSONParser jsonParser = new JSONParser();

            JSONObject javaObject;
            try {
                javaObject = new JSONObject("{\"Imam\":\"Muhammad Multe Khateeb\"}");
                String oneObjectsItem = javaObject.toString();
                Log.d("JSON", "ContactHolder: " + oneObjectsItem);
                //Now parse from the file
                JSONparser jsonParser1 = null;
                //Log.d("JSON", "ContactHolder: " + jsonParser1.jsonParse());
                //Log.d("JSON parsing from file:", "ContactHolder: " + jsonParser1.getJsonFromAssets(this.txtName.getContext(), "./imam.json"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            /*
            JsonArrayRequest request = new JsonArrayRequest( Request.Method.GET, uri, null,
                    new Response.Listener<JSONArray>()
                    {
                        @Override
                        public void onResponse( JSONArray response )
                        {

                            cityID = "";
                            try
                            {
                                JSONObject cityInfo = response.getJSONObject( 0 );
                                cityID = cityInfo.getString( "woeid" );
                            }
                            catch( JSONException e )
                            {

                                e.printStackTrace();
                            }

                            volleyResponseListener.onResponse( cityID );
                        }
                    }, new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse( VolleyError error )
                {

//

                    volleyResponseListener.onError( "Error occurred" );
                }
            } );
            */
            txtName = itemView.findViewById(R.id.txt_name);
            txtNumber = itemView.findViewById(R.id.txt_number);
        }

        /*
        private String jsonParse() {
            String json = null;
            try{
                Activity context;
                JSONParser jsonParser;

                //InputStream inputStream = getApplicationContext().getAssets().open("imam.json");
            }
            catch (Exception e)
            {
                Log.d("MyAdapter", "jsonParse: ");
            }

            return json;
        }*/


        public void setContactName(String name) {
            txtName.setText(name);
        }

        public void setContactNumber(String number) {
            txtNumber.setText(number);
        }

        public void setContactPhoto(String uri) {
            File imgFile = new File(uri);

            if(imgFile.exists())
            {
                Bitmap myBitMap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                profilePicture.setImageBitmap(myBitMap);
            }
            //profilePicture.setImageResource(R.drawable.hire_islamic_experts);
        }
    }
}