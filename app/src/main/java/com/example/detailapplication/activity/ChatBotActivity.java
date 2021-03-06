package com.example.detailapplication.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.detailapplication.ChatRVAdapter;
import com.example.detailapplication.ChatsModel;
import com.example.detailapplication.R;

import org.json.JSONException;

import java.util.ArrayList;

public class ChatBotActivity extends AppCompatActivity {

    private EditText userMsgEdt;
    private final String BOT_KEY = "bot";

    //Creating a variable for array list and adapter class.
    private ArrayList<ChatsModel> messageModalArrayList;
    private ChatRVAdapter messageRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        //  On below line we are initializing all our views.
        // creating variables for our
        // widgets in xml file.
        RecyclerView chatsRV = findViewById(R.id.idRVChats);
        ImageButton sendMsgIB = findViewById(R.id.idFABSend);
        userMsgEdt = findViewById(R.id.idEdtMessage);

        // below line is to initialize our request queue.
        // creating a variable for
        // our volley request queue.
        RequestQueue mRequestQueue = Volley.newRequestQueue(ChatBotActivity.this);
        mRequestQueue.getCache().clear();

        // creating a new array list
        messageModalArrayList = new ArrayList<>();

        sendMsgIB.setOnClickListener(view -> handleMessageImageButton());

        // adding on click listener for send message button.

        // on below line we are initialing our adapter class and passing our array list to it.
        messageRVAdapter = new ChatRVAdapter(messageModalArrayList, this);

        // below line we are creating a variable for our linear layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChatBotActivity.this, RecyclerView.VERTICAL, false);

        // below line is to set layout
        // manager to our recycler view.
        chatsRV.setLayoutManager(linearLayoutManager);

        // below line we are setting
        // adapter to our recycler view.
        chatsRV.setAdapter(messageRVAdapter);
    }

    public void handleMessageImageButton(){
        // checking if the message entered
        // by user is empty or not.
        if (userMsgEdt.getText().toString().isEmpty()) {
            // if the edit text is empty display a toast message.
            Toast.makeText(ChatBotActivity.this, "Please enter your message..", Toast.LENGTH_SHORT).show();
            return;
        }

        // calling a method to send message
        // to our bot to get response.
        sendMessage(userMsgEdt.getText().toString());

        // below line we are setting text in our edit text as empty
        userMsgEdt.setText("");
    }

    private void sendMessage(String userMsg) {
        // below line is to pass message to our
        // array list which is entered by the user.
        String USER_KEY = "user";
        messageModalArrayList.add(new ChatsModel(userMsg, USER_KEY));
        messageRVAdapter.notifyItemChanged(messageModalArrayList.size()- 1);

        // url for our brain
        // make sure to add mshape for uid.
        // make sure to add your url.
        String url = "http://api.brainshop.ai/get?bid=162882&key=t3JF55qSHHY5Ga5v&uid=[abdullah97]&msg=" + userMsg;

        // creating a variable for our request queue.
        RequestQueue queue = Volley.newRequestQueue(ChatBotActivity.this);

        // on below line we are making a json object request for a get request and passing our url .
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                // in on response method we are extracting data
                // from json response and adding this response to our array list.
                String botResponse = response.getString("cnt");
                messageModalArrayList.add(new ChatsModel(botResponse, BOT_KEY));

                // notifying our adapter as data changed.
                messageRVAdapter.notifyItemChanged(messageModalArrayList.size() - 1);
            } catch (JSONException e) {
                e.printStackTrace();

                // handling error response from bot.
                messageModalArrayList.add(new ChatsModel("No response", BOT_KEY));
                messageRVAdapter.notifyItemChanged(messageModalArrayList.size() - 1);
            }
        }, error -> {
            // error handling.
            messageModalArrayList.add(new ChatsModel("Sorry no response found... \"Innkeeper: \\\"The room is $15 a night. It's $5 if you make your own bed.\\\" Guest: \\\"I'll make my own bed.\\\" Innkeeper: \\\"Good. I'll get you some nails and wood.\\\"\"", BOT_KEY));
            Toast.makeText(ChatBotActivity.this, "No response from the bot... \"Innkeeper: \\\"The room is $15 a night. It's $5 if you make your own bed.\\\" Guest: \\\"I'll make my own bed.\\\" Innkeeper: \\\"Good. I'll get you some nails and wood.\\\"\"", Toast.LENGTH_SHORT).show();
        });

        jsonObjectRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) {

            }
        });

        // at last adding json object 
        // request to our queue.
        queue.add(jsonObjectRequest);
    }
}