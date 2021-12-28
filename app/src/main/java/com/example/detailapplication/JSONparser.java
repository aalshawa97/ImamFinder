package com.example.detailapplication;

import android.util.Log;
import android.content.Context;
import android.app.Activity.*;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class JSONparser extends AppCompatActivity {

    static String getJsonFromAssets(Context context, String fileName) {
        /*
        //Create json object from string
        Map json = new Map() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsValue(@Nullable Object o) {
                return false;
            }

            @Nullable
            @Override
            public Object get(@Nullable Object o) {
                return null;
            }

            @Nullable
            @Override
            public Object put(Object o, Object o2) {
                return null;
            }

            @Nullable
            @Override
            public Object remove(@Nullable Object o) {
                return null;
            }

            @Override
            public void putAll(@NonNull Map map) {

            }

            @Override
            public void clear() {

            }

            @NonNull
            @Override
            public Set keySet() {
                return null;
            }

            @NonNull
            @Override
            public Collection values() {
                return null;
            }

            @NonNull
            @Override
            public Set<Entry> entrySet() {
                return null;
            }
        };
        JSONObject newJson = new JSONObject(json);

        // Get keys from json

        Iterator<String> panelKeys = newJson.keys();

        while(panelKeys.hasNext()) {
            JSONObject panel = newJson.getJSONObject(panelKeys.next()); // get key from list
            String id  = panel.getString("id");
            String number  = panel.getString("number");
        }
        */

        return "";
    }
  /*
    static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
    */

    public String jsonParse() {
        String json = null;
        try{
            InputStream inputStream = getAssets().open("imam.json");
            int size = inputStream.available();
            byte [] buffer = new byte[size];
            inputStream.read();
            inputStream.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            ArrayList<String> imamList = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                if(object.getString("Imam").equals("Muhammad Multe Khateeb")){
                    imamList.add(object.getString("Imam"));
                    Log.d("JSON", "jsonParse: " + imamList.toString());
                    Toast.makeText(getApplicationContext(), imamList.toString(), Toast.LENGTH_LONG);
                }
            }
        }
        catch (Exception e)
        {
            Log.d("MyAdapter", "jsonParse: ");
        }

        return json;
    }
}
